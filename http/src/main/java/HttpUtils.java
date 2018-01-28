import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/9 15:14:28
 * @Version v1.0
 */

public class HttpUtils {
    private static final Logger logger = Logger.getLogger(HttpUtils.class);
    public String sendGet(String url, Map<String, Object> params){
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + this.parseParamsToQueryString(params);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("service-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            //Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String sendPost(String url, Map<String, Object> params) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String param = this.parseParamsToQueryString(params);//params);
        try {

            CloseableHttpClient closeableHttpClient = createHttpsClient();

            // 配置要 POST 的数据begin
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // 设置为浏览器兼容模式
            multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            // 设置请求的编码格式
            HttpPost httppost = new HttpPost(url + "?" + param);

            multipartEntityBuilder.setCharset(Charset.forName(HTTP.UTF_8));
            // 生成 HTTP POST 实体
            StringEntity s = new StringEntity(param);
            httppost.setEntity(s);
            HttpResponse httpResponse = closeableHttpClient.execute(httppost);
            HttpEntity httpEntity2 = httpResponse.getEntity();

            logger.info("httpResponse.getStatusLine().getStatusCode():"+httpResponse.getStatusLine().getStatusCode());
            // 如果状态码为200,就是正常返回
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(httpEntity2);
                // 得到返回的字符串
                logger.info(result);
                // 如果是下载文件,可以用response.getEntity().getContent()返回InputStream
            }else {
                result = EntityUtils.toString(httpEntity2);
                // 得到返回的字符串
                logger.info(result);
            }

//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("service-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！"+e);
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static CloseableHttpClient createHttpsClient() throws Exception   {
        X509TrustManager x509mgr = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] xcs, String string) {
            }
            public void checkServerTrusted(X509Certificate[] xcs, String string) {
            }
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { x509mgr }, new java.security.SecureRandom());
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslContext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    private String parseParamsToQueryString(Map<String, Object> params){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(String item:params.keySet()){
            if(count++ == 0){
                sb.append(item+"="+params.get(item));
            }else{
                sb.append("&"+item+"="+params.get(item));
            }
        }
        return sb.toString();
    }
}
