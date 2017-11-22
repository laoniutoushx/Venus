package com.chinaums.netpay.demo;

/**
 * Created by faliny on 2017/8/31.
 */

import com.chinaums.netpay.demo.domain.Goods;
import com.chinaums.netpay.demo.util.Util;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class h5PayDemo {

    final private static String md5Key = "hEPwhDiX3GbbDbkYQkp2y5bwYmiKkpJ6Gc4HRNhaHkbNicFd";
    final private static String msgId = "4000";
    final private static String apiUrl = "http://umspay.izhong.me/netpay-portal/webpay/pay.do";
    final private static String msgSrc = "test";
    final private static String mid = "898310060514010";
    final private static String instMid = "H5DEFAULT";
    final private static String notifyUrl = "http://30877a7.nat123.cc:51643/demo/notifyUrl.do";
    final private static String returnUrl = "http://30877a7.nat123.cc:51643/demo/returnUrl.do";

    /**
     * 接收并处理H5支付请求
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/h5pay.do", method = RequestMethod.GET)
    public String h5Pay(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 准备商品信息
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods("0001", "Goods Name", 1L, 100L, "Auto", "goods body"));
        goodsList.add(new Goods("0002", "Goods Name", 2L, 200L, "Auto", "goods body"));

        // 组织请求报文，具体参数请参照接口文档，以下仅作模拟
        JSONObject json = new JSONObject();
        json.put("msgType", "WXPay.h5Pay");
        json.put("requestTimestamp", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        json.put("goods", goodsList);
        json.put("mid", mid);
        json.put("tid", "00000001");
        json.put("msgSrc", msgSrc);
        json.put("instMid", instMid);
        json.put("merOrderId", Util.genMerOrderId(msgId));
        json.put("totalAmount", 1);
        json.put("notifyUrl", notifyUrl);
        json.put("returnUrl", returnUrl);
        json.put("sceneType", "AND_WAP");
        json.put("merAppName", "全民付");
        json.put("merAppId", "http://www.chinaums.com");

        String url = Util.makeOrderRequest(json, md5Key, apiUrl);
        response.sendRedirect(url);
        return null;
    }


    /**
     * 接收通知的方法
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/notifyUrl.do", method = RequestMethod.POST)
    public void notifyHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> params = Util.getRequestParams(request);

        // 验签
        boolean checkRet = Util.checkSign(md5Key, params);

        // 收到通知后记得返回SUCCESS
        PrintWriter writer = response.getWriter();
        writer.print("SUCCESS");
        writer.flush();
    }

    /**
     * 回跳地址
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/returnUrl.do", method = RequestMethod.GET)
    public void goReturnUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> params = Util.getRequestParams(request);

        // 验签
        boolean checkRet = Util.checkSign(md5Key, params);
    }
}
