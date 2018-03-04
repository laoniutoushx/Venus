import com.sun.net.httpserver.Headers;
import com.sun.xml.internal.ws.developer.WSBindingProvider;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import sos.haruhi.ws.client.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.soap.MTOMFeature;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceTest {
    private IUserService port;
    private UserService us;
    private String namespace = "http://sos.haruhi.ws/test/";


    @Before
    public void init() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ws?wsdl");
        QName qName = new QName("http://sos.haruhi.ws/test/", "UserService");
        us = new UserService(url, qName);
        port = us.getUserServicePort(new MTOMFeature());
    }

    @Test
    public void testList(){
        List<User> list = port.list();
        for(User u:list){
            System.out.println(u.getNickname());
        }
    }

    @Test
    public void testAdd() throws JAXBException, ParserConfigurationException {
        // 将一个对象转换为 xml 通过 JAXB
        JAXBContext jaxb = JAXBContext.newInstance(License.class);
        User ru = new User();
        ru.setNickname("超级管理");
        ru.setUsername("admin");
        ru.setPassword("123");
        License license = new License();
        license.setRegisterUser(ru);

        QName name = new QName(namespace, "license");

        JAXBElement<License> jele = new JAXBElement<License>(name, License.class, license);


        Marshaller mars = jaxb.createMarshaller();
        mars.setProperty(Marshaller.JAXB_FRAGMENT, true);
        mars.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        mars.marshal(jele, System.out);

        // 2.转换为 DOM
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        mars.marshal(jele, doc);

        // 3.通过 headers.create 方法 完成 header 的添加
        // 获取 WSB
        WSBindingProvider wsb = (WSBindingProvider) port;
        wsb.setOutboundHeaders(com.sun.xml.internal.ws.api.message.Headers.create(doc.getDocumentElement()));

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("123");
        u.setNickname( "张三");
        try {
            port.add(u);
        } catch (UserException_Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogin(){
        try {
            User user = port.login("admin", "123");
            System.out.println(user.getNickname());
        } catch (UserException_Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUplaod(){
        try {
            byte[] file = FileUtils.readFileToByteArray(new File("d:/Picture/wallhaven-4895.jpg"));
            port.upload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
