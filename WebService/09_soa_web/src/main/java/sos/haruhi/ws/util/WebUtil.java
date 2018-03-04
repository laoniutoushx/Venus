package sos.haruhi.ws.util;

import com.sun.xml.internal.ws.developer.WSBindingProvider;
import org.w3c.dom.Document;
import sos.haruhi.ws.webservice.IUserService;
import sos.haruhi.ws.webservice.License;
import sos.haruhi.ws.webservice.User;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WebUtil {

    private static final String namespace = "http://sos.haruhi.ws/test/";

    public static void addLicenseHeader(IUserService port, HttpServletRequest req){
        try {
            // 将一个对象转换为 xml 通过 JAXB
            JAXBContext jaxb = JAXBContext.newInstance(License.class);

            User ru = (User) req.getSession().getAttribute("loginUser");
//            User ru = new User();
//            ru.setNickname("超级管理");
//            ru.setUsername("admin");
//            ru.setPassword("123");
            if(ru == null){
                return;
            }

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
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
