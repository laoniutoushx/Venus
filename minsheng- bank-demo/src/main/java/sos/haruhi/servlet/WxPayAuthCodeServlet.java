package sos.haruhi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import sos.haruhi.config.Alipay;
import sos.haruhi.config.MinShengConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description sos.haruhi.servlet in Venus
 * Created by SuzumiyaHaruhi on 2017/10/30.
 */
@WebServlet(urlPatterns = "/QRCode_Wxpay_MinSheng")
public class WxPayAuthCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String state = req.getParameter("state");
        AlipayClient client = new DefaultAlipayClient(Alipay.URL, Alipay.APPID, Alipay.RSA_PRIVATE_KEY, Alipay.FORMAT, "GBK", Alipay.RAS_PUBLIC_KEY, Alipay.SIGNTYPE);
        AlipaySystemOauthTokenRequest  alipay_auth_req=new AlipaySystemOauthTokenRequest();
        alipay_auth_req.setCode(req.getParameter("auth_code"));
        alipay_auth_req.setGrantType("authorization_code");
        String user_id = null;
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = client.execute(alipay_auth_req);
            System.out.println("获取支付宝授权签名：");
            JSONObject alipayRespAuth = JSON.parseObject(oauthTokenResponse.getBody());
            alipayRespAuth = (JSONObject) alipayRespAuth.get("alipay_system_oauth_token_response");
            System.out.println(oauthTokenResponse.getBody());
            user_id = (String) alipayRespAuth.get("user_id");
            System.out.println("用户ID："+user_id);
            System.out.println("--------------------------------------");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("统一下单：");
        JSONObject obj = new JSONObject();
        obj.put("testPlatformId", MinShengConfig.testPlatformId);
        obj.put("testMerchantNo", MinShengConfig.testMerchantNo);
        obj.put("selectTradeType", "H5_ZFBJSAPI");      // 支付类型
        obj.put("amount", "1");     // 交易金额，以分为单位
        obj.put("userId", user_id);     //2088102173172617");      // 支付宝沙箱用户
        obj.put("orderInfo", "统一下单DEMO-API_H5_ZFBJSAPI");       // 交易金额，以分为单位
        obj.put("merchantSeq", "DD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"99999");    // 订单号
        //obj.put("mchSeqNo", "C000000001801710251129133692");    // 流水号
        obj.put("transDate", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        obj.put("transTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("notifyUrl", "http://www.laoniutoushx.top:51595/notify");   // 异步通知
        String json = obj.toJSONString();
        System.out.println("订单号："+obj.get("merchantSeq"));
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
        System.out.println("下单完成："+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        System.out.println("耗时："+(System.currentTimeMillis()-Long.valueOf(state))+" ms");
        System.out.println("--------------------------------------");
        PrintWriter pw = resp.getWriter();
        resp.setContentType("application/text");
        pw.write(tradeNO);
        pw.close();
    }
}
