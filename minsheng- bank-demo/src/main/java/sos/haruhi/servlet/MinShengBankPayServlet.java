package sos.haruhi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import sos.haruhi.config.MinShengConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Description sos.haruhi.servlet in Venus
 * Created by SuzumiyaHaruhi on 2017/10/25.
 */
@WebServlet(urlPatterns = "/index")
public class MinShengBankPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("service-agent");
        System.out.println(req.getParameter("hahah"));
        if(StringUtils.indexOf(userAgent, "AlipayClient") > -1){
            System.out.println("支付宝授地址："+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            System.out.println(MinShengConfig.test_Alipay_Auth_Url+ URLEncoder.encode(MinShengConfig.test_Alipay_Anth_Redirect_Url, "GBK") + "&state="+System.currentTimeMillis());
            System.out.println("--------------------------------------");
            resp.sendRedirect(MinShengConfig.test_Alipay_Auth_Url+ URLEncoder.encode(MinShengConfig.test_Alipay_Anth_Redirect_Url, "GBK") + "&state="+System.currentTimeMillis());
            return;
        }
        if(StringUtils.indexOf(userAgent, "MicroMessenger") > -1){
            System.out.println("微信授权地址："+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            System.out.println("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb099afdf746456&redirect_uri=http%3A%2F%2F192.168.2.100%3A8080%2FminSheng_Wxpay_AuthCode.jsp&response_type=code&scope=snsapi_base&state="+System.currentTimeMillis()+"#wechat_redirect");
            System.out.println("--------------------------------------");
            resp.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb099afdf746456&redirect_uri=http%3A%2F%2F192.168.2.100%3A8080%2FminSheng_Wxpay_AuthCode.jsp&response_type=code&scope=snsapi_base&state="+System.currentTimeMillis()+"#wechat_redirect");
            return;
        }
        System.out.println("用手机扫描支付");
    }
}


