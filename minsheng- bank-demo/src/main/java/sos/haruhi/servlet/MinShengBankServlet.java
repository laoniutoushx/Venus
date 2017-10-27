package sos.haruhi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sos.haruhi.config.MinShengConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description sos.haruhi.servlet in Venus
 * Created by SuzumiyaHaruhi on 2017/10/25.
 */
@WebServlet(urlPatterns = "/index")
public class MinShengBankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject obj = new JSONObject();
        obj.put("platformId", MinShengConfig.platformId);
        obj.put("merchantNo", MinShengConfig.merchantNo);
        obj.put("selectTradeType", "H5_ZFBJSAPI");      // 支付类型
        obj.put("amount", "1");     // 交易金额，以分为单位
        obj.put("userId", MinShengConfig.userId);//2088102172266904");      // 支付宝沙箱账户
        obj.put("orderInfo", "统一下单DEMO-API_H5_ZFBJSAPI");       // 交易金额，以分为单位
        obj.put("merchantSeq", "DD2017102515178419999");    // 订单号
        //obj.put("mchSeqNo", "C000000001801710251129133692");    // 流水号
        obj.put("transDate", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        obj.put("transTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("notifyUrl", "http://192.168.2.120:8080/notify");   // 异步通知
        String json = obj.toJSONString();

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
            returnContext = MinShengConfig.sendPost(MinShengConfig.testURL, encryptContext);
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
        String body = (String) dncryptJSON.get("body");
        String payInfo = (String) JSON.parseObject(body).get("payInfo");
        System.out.println(payInfo);
        String tradeNO = payInfo.split("\\|\\|")[0].split("=")[1];
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        //req.getRequestDispatcher("https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2016082000297197&scope=auth_base&redirect_uri=http%3A%2F%2F192.168.2.120%3A8080%2FminSheng_Alipay_JSAPI.jsp").forward(req, resp);
        resp.sendRedirect("https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=2016082000297197&scope=auth_base&redirect_uri=http%3A%2F%2F192.168.2.120%3A8080%2FminSheng_Alipay_JSAPI.jsp&state="+tradeNO);
        //resp.sendRedirect("https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2016082000297197&scope=auth_userinfo&redirect_uri=http%3A%2F%2F192.168.2.120%3A8080%2Fnotify");
    }
}


