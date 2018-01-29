package sos.haruhi.test;

import com.haruhi.sos.IMyService;
import com.haruhi.sos.MyServiceImplService;
import com.haruhi.sos.User;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 默认生成的代码，加入头消息之后，格式错了乱
 */
public class TestSoapHandler {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws?wsdl");
        QName qName = new QName("http://haruhi.com/", "MyServiceImplService");
        //Service service = Service.create(url, qName);

        MyServiceImplService mis = new MyServiceImplService(url, qName);
        IMyService ms = mis.getMyServiceImplPort();
        ms.login("admin", "123");
    }
}
