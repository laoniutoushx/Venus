package com.haruhi.another;

import com.haruhi.com.haruhi.other.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws?wsdl");
        QName qName = new QName("http://another.haruhi.com/", "MathServiceImplService");
        Service service = Service.create(url, qName);

        IMathService mathService = service.getPort(IMathService.class);

        System.out.println(mathService.sum(2, 6));
    }
}
