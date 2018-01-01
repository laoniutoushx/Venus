package com.haruhi.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.ws</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/1 21:46:57
 * @Version v1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8888/ws?wsdl");
            QName qName = new QName("http://ws.haruhi.com/", "ServiceImplService");
            Service service = Service.create(url, qName);
            IService s = service.getPort(IService.class);
            System.out.println(s.add(22, 33));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
