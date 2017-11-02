package sos.haruhi.config;

import cfca.sm2.signature.SM2PrivateKey;
import cfca.sm2rsa.common.Mechanism;
import cfca.sm2rsa.common.PKIException;
import cfca.util.CertUtil;
import cfca.util.EnvelopeUtil;
import cfca.util.KeyUtil;
import cfca.util.SignatureUtil2;
import cfca.util.cipher.lib.JCrypto;
import cfca.util.cipher.lib.Session;
import cfca.x509.certificate.X509Cert;
import cfca.x509.certificate.X509CertHelper;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.net.URLEncoder.encode;

/**
 * Description sos.haruhi.config in Venus
 * Created by SuzumiyaHaruhi on 2017/10/25.
 */
public class MinShengConfig {

    final public static String testPlatformId = "A00012017050000000545";    // 测试平台号
    final public static String testMerchantNo = "M29002017100000030270";    // 民生测试商户号 （北科维托测试账户）
    final public static String testURL = "http://wxpay.cmbc.com.cn:1080/mobilePlatform/appserver/lcbpPay.do";
    final public static String onLineURL = "https://epay.cmbc.com.cn/appweb/appserver/lcbpPay.do";

    //final public static String testHost = "http://www.laoniutoushx.top:51595/";
    final public static String testHost = "http://192.168.2.111:8080/";
    final public static String test_Alipay_Anth_Redirect_Url = testHost + "minSheng_Alipay_AuthCode.jsp";
    final public static String test_Alipay_Business_Url = testHost + "QRCode_Alipay_MinSheng";
    final public static String test_Alipay_Notify_Url = testHost + "notify";
    final public static String test_Alipay_Auth_Url = "https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=2016082000297197&scope=auth_base&redirect_uri=";

    private static final String propsPath = "/config.properties";
    private static Properties props = new Properties();
    private static boolean initFlag = false;



    /**
     * 初始化配置文件
     */
    private static synchronized void init() {
        if (!initFlag) {
            InputStream in = null;
            try {
                in = new FileInputStream(new File("S:\\Venus\\minsheng- bank-demo\\src\\main\\java\\sos\\haruhi\\config\\config.properties"));
                //in = MinShengConfig.class.getResourceAsStream("S:\\Venus\\minsheng- bank-demo\\src\\main\\java\\sos\\haruhi\\config\\config.properties");
                props.load(in);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
                }
            }
            initFlag = true;
        }
    }

    /**
     * 获取初始化参数
     * @param propName
     * @return
     */
    public static String getProperty(String propName) {
        init();
        return props.getProperty(propName);
    }


    private static Session session;

    static {
        try {
            JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);
        } catch (PKIException e) {
            e.printStackTrace();
        }
    }

    /**
     * 签名
     *
     * @param sign
     * @param context
     * @return
     */
    public static String sign(String sign, String context) {
        GsonBuilder builder = new GsonBuilder();
        builder.disableHtmlEscaping();
        Gson gson = builder.create();
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("sign", sign);
        paramMap.put("body", context);
        String signInfo = gson.toJson(paramMap); // 待加密字符串
        return signInfo;
    }

    /**
     * 加密
     *
     * @param signContext
     *            需要加密的报文
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String encrypt(String signContext) {
        //String certAbsPath = MinShengConfig.getProperty("merchantPublicKey");
        String certAbsPath = MinShengConfig.getProperty("bankPublicKey");
        X509Cert cert = null;
        try {
            cert = X509CertHelper.parse(certAbsPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PKIException e) {
            e.printStackTrace();
        }
        X509Cert[] certs = { cert };
        byte[] encryptedData = null;
        try {
            encryptedData = EnvelopeUtil.envelopeMessage(signContext.getBytes("UTF8"), Mechanism.SM4_CBC, certs);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (PKIException e) {
            e.printStackTrace();
        }
        String encodeText = null;
        try {
            encodeText = new String(encryptedData, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeText;
    }

    /**
     * 解密
     *
     * @param encryptContext
     *            需要解密的报文
     * @return
     */
    public static String dncrypt(String encryptContext) {
        String priKeyAbsPath = MinShengConfig.getProperty("merchantPrivateKey");
        String priKeyPWD = MinShengConfig.getProperty("merchantPwd");
        String decodeText = null;
        try {
            PrivateKey priKey = KeyUtil.getPrivateKeyFromSM2(priKeyAbsPath, priKeyPWD);
            X509Cert cert = CertUtil.getCertFromSM2(priKeyAbsPath);
            byte[] sourceData = EnvelopeUtil.openEvelopedMessage(encryptContext.getBytes("UTF8"), priKey, cert, session);
            decodeText = new String(sourceData, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeText;
    }

    /**
     * 验证签名
     *
     * @param dncryptContext
     *            需要验证签名的明文
     * @return
     */
    public static String signCheck(String dncryptContext) {
        //String certAbsPath = MinShengConfig.getProperty("merchantPublicKey");
        String certAbsPath = MinShengConfig.getProperty("bankPublicKey");
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, Object> paraMap = gson.fromJson(dncryptContext, Map.class);
        String sign = paraMap.get("sign").toString();
        String body = paraMap.get("body").toString();
        boolean isSignOK = false;
        try {
            X509Cert cert = X509CertHelper.parse(certAbsPath);
            PublicKey pubKey = cert.getPublicKey();
            isSignOK = new SignatureUtil2().p1VerifyMessage(Mechanism.SM3_SM2, body.getBytes("UTF8"),
                    sign.getBytes(), pubKey, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isSignOK) {
            return "验签通过";
        } else {
            return "验签不通过";
        }
    }

    public static String getSign(String context) {
        String priKeyAbsPath = MinShengConfig.getProperty("merchantPrivateKey");
        String priKeyPWD = MinShengConfig.getProperty("merchantPwd");
        String sign = "";
        try {
            JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);
            SM2PrivateKey priKey = KeyUtil.getPrivateKeyFromSM2(priKeyAbsPath, priKeyPWD);
            sign = new String(
                    new SignatureUtil2().p1SignMessage(Mechanism.SM3_SM2, context.getBytes("UTF8"), priKey, session));
        } catch (PKIException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param json
     *            请求参数，请求参数是Json格式。
     * @return 所代表远程资源的响应结果
     * @throws IOException
     * @throws IllegalStateException
     */
    public static String sendPost(String url, String json)
            throws IllegalStateException, IOException {
        // 1. 请求客户端及参数配置
        CloseableHttpClient client = HttpClients.createDefault();
        // 1.1 参数1：创建代理，参数分别是(代理IP, 代理端口, 类型)[根据需要配置1]
//        String proxyIp = "192.168.1.1";
//        int proxyPort = 3281;
        String protocol = "http";
//        HttpHost proxy = new HttpHost(proxyIp, proxyPort, protocol);
        // 1.2 参数2：创建配置参数，其中设置代理[根据需要配置1]
        RequestConfig config = RequestConfig.custom()//.setProxy(proxy)
                .setSocketTimeout(10000).setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .setStaleConnectionCheckEnabled(true).build();
        // 1.3 参数3：请求目标uri
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int port = uri.getPort();
        if (port == -1) {
            port = 80;// 协议默认端口
        }
        // 2. 获取请求目标，创建请求对象，封装请求参数
        // 2.1 获取请求目标
        HttpHost target = new HttpHost(uri.getHost(), port, protocol);
        // 2.2 创建请求对象
        HttpPost request = new HttpPost(uri);
        // 设置报文头
        // 2.3 封装请求参数，设置配置信息
        request.setHeader("businessContext", json);
        request.setHeader("testMerchantNo", "");
        request.setHeader("merchantSeq", "");
        request.setHeader("reserve1", "");
        request.setHeader("reserve2", "");
        request.setHeader("reserve3", "");
        request.setHeader("reserve4", "");
        request.setHeader("reserve5", "");
        request.setHeader("reserveJson", "");
        request.setHeader("securityType", "");
        request.setHeader("sessionId", "");
        request.setHeader("source", "");
        request.setHeader("transCode", "");
        request.setHeader("transDate", "");
        request.setHeader("transTime", "");
        request.setHeader("version", "");

        JSONObject obj = new JSONObject();
        obj.put("businessContext", json);
        StringEntity se = new StringEntity(obj.toJSONString(), "UTF-8");
        se.setContentType("application/json");
        request.setEntity(se);
//        request.setConfig(config);
        // 3. 发送post请求
        CloseableHttpResponse response = null;
        try {
            response = client.execute(target, request);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 4. 读取响应信息
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String message = null;
        while ((message = reader.readLine()) != null) {
            result.append(message).append(System.getProperty("line.separator"));
        }
        String resultStr = result.toString();
        // 下边代码移除空白字符
        resultStr = resultStr.trim();
        resultStr = resultStr.replace("\n", "");
        resultStr = resultStr.replace("\r", "");
        resultStr = resultStr.replace("\t", "");
        reader.close();
        response.close();
        client.close();
        return resultStr;
    }

}
