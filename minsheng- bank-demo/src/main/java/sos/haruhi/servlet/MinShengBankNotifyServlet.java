package sos.haruhi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sos.haruhi.config.MinShengConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description sos.haruhi.servlet in Venus
 * Created by SuzumiyaHaruhi on 2017/10/25.
 */
@WebServlet(urlPatterns = "/notify")
public class MinShengBankNotifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            throw new Exception("非法get请求");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("民生银行异步通知：");
        // 接收异步通知的关键代码
        StringBuffer noticeContext = new StringBuffer();
        BufferedReader reader = req.getReader();
        String data = null;
        while ((data = reader.readLine()) != null) {
            noticeContext.append(data);
        }
        // 给通知返回结果的输出流
        PrintWriter out = resp.getWriter();
        // 此处对通知密文进行解密，通过后返回字符串”SUCCESS”，否则返回”E”
        out.print("SUCCESS");
        out.close();
        System.out.println("返回SUCCESS");
        System.out.println("--------------------------------------");
        System.out.println("异步通知密文：");
        System.out.println(noticeContext);
        JSONObject dncryptJSON = JSON.parseObject(noticeContext.toString());
        String dncryptContext = MinShengConfig.dncrypt((String) dncryptJSON.get("context"));
        System.out.println("--------------------------------------");
        System.out.println("解密后：");
        System.out.println(dncryptContext);

        dncryptJSON = JSON.parseObject(dncryptContext);
        dncryptJSON = JSON.parseObject((String) dncryptJSON.get("body"));
        String tradeStatus = (String) dncryptJSON.get("tradeStatus");       //S-订单交易成功
        String orderNo = (String) dncryptJSON.get("orderNo");               //原交易商户订单号
        String bankTradeNo = (String) dncryptJSON.get("bankTradeNo");       //收单系统流水号
        Double amount = (Double) dncryptJSON.get("amount");                 //单位到分

    }
}
