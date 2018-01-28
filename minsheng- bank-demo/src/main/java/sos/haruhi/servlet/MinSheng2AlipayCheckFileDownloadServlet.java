package sos.haruhi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import sos.haruhi.config.MinShengConfig;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description sos.haruhi.servlet in Venus
 * Created by SuzumiyaHaruhi on 2017/11/6.
 * 对账文件下载
 */
@WebServlet(urlPatterns = "/download")
public class MinSheng2AlipayCheckFileDownloadServlet extends HttpServlet {
    /**
     * Receives standard HTTP requests from the public
     * <code>service</code> method and dispatches
     * them to the <code>do</code><i>XXX</i> methods defined in
     * this class. This method is an HTTP-specific version of the
     * {@link Servlet#service} method. There's no
     * need to override this method.
     *
     * @param req  the {@link HttpServletRequest} object that
     *             contains the request the client made of
     *             the servlet
     * @param resp the {@link HttpServletResponse} object that
     *             contains the response the servlet returns
     *             to the client
     * @throws IOException      if an input or output error occurs
     *                          while the servlet is handling the
     *                          HTTP request
     * @throws ServletException if the HTTP request
     *                          cannot be handled
     * @see Servlet#service
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject body = download("0");
        String fileMd5 = (String) body.get("fileMd5");
        int segmentCount = Integer.valueOf((String) body.get("segmentCount"));
        StringBuilder segmentContent = new StringBuilder();
        File file = new File("S:\\download.txt");
        List<byte[]> byteList = new ArrayList<byte[]>();
        int length = 0;
        for(int i = 0; i < segmentCount;){
            body = download(String.valueOf(++i));
            byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(
                    (String) body.get("segmentContent"));
            length += bytes.length;
            byteList.add(bytes);
            segmentContent.append(new String(bytes, "gbk"));   // 文件原文
        }
        byte[] result = new byte[length];
        length = 0;
        for(byte[] item:byteList){
            System.arraycopy(item, 0, result, length, item.length);
            length += item.length;
        }
        FileOutputStream fos = new FileOutputStream(file);
        for(byte[] item:byteList){
            fos.write(item);
        }
        fos.flush();
        fos.close();

        String md5 = MinShengConfig.encoderByMd5(result);
        if(StringUtils.equals(fileMd5, md5)){

        }else{
//            throw new RuntimeException("对账文件 md5 校验出错，请联系管理员");
        }

        String[] strs = segmentContent.toString().split("\n");
        List<String[]> list = new ArrayList<String[]>();
        for(String item:strs){
            if(StringUtils.isNotBlank(item)){
                String[] temp = new String[20];
                temp[0] = "";
                for(int i = 0,  j = 0; i < item.length(); i++){
                    Character ch = item.charAt(i);
                    if(StringUtils.equals(String.valueOf(ch), "|")){
                        temp[++j] = "";
                    }else{
                        temp[j] += String.valueOf(ch);
                    }
                }
                list.add(temp);
            }
        }
        System.out.println(System.getProperty("service.dir"));
        FTPClient ftp = new FTPClient();
//        String sss = segmentContent.toString();
//        InputStream is = new DataInputStream();
//        ftp.storeFile("", is);

        System.out.println(list);
    }

    public JSONObject download(String segmentIndex){
        JSONObject obj = new JSONObject();
        obj.put("platformId", MinShengConfig.testPlatformId);   // 接入平台号
        obj.put("slcTransDate", "20171109");    // 交易明细单日期
        obj.put("segmentIndex", segmentIndex);      // 块文件索引
        obj.put("fileType", "ZFB");     //  文件类型
        obj.put("segmentSize", "1024");       // 块大小
        obj.put("reserve", "");         // 备注

        String json = obj.toJSONString();
        System.out.println("接入平台号："+obj.get("platformId"));
        String sign = MinShengConfig.getSign(json);
        System.out.println("--------------------------------------");
        System.out.println("签名：");
        System.out.println(sign);

        String signContext = MinShengConfig.sign(sign, json);
        System.out.println("--------------------------------------");
        System.out.println("加密前：");
        System.out.println(signContext);

        String encryptContext = MinShengConfig.encrypt(signContext);
        System.out.println("--------------------------------------");
        System.out.println("加密后：");
        System.out.println(encryptContext);

        System.out.println("--------------------------------------");
        System.out.println("请求报文：");
        String returnContext = null;
        try {
            returnContext = MinShengConfig.sendPost(MinShengConfig.test_Download_URL, encryptContext);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(returnContext);
        }
        JSONObject returnJSON = JSON.parseObject(returnContext);

        String dncryptContext = MinShengConfig.dncrypt((String) returnJSON.get("businessContext"));
        System.out.println("--------------------------------------");
        System.out.println("解密后：");
        System.out.println(dncryptContext);

        String signChkResult = MinShengConfig.signCheck(dncryptContext);
        System.out.println("--------------------------------------");
        System.out.println("验证签名结果：");
        System.out.println(signChkResult);
        JSONObject dncryptJSON = JSON.parseObject(dncryptContext);
        return JSON.parseObject((String) dncryptJSON.get("body"));
    }
}
