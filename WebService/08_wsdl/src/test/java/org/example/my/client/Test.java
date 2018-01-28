package org.example.my.client;

import org.example.my.test.IMyservice;
import org.example.my.test.MyServiceImplService;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;


public class Test {
    /**
     * 使用本地接口调用服务端的服务
     */
    @org.junit.Test
    public void testNoHeader() {
        MyServiceImplService serviceImpl = new MyServiceImplService();
        IMyservice service = serviceImpl.getMyServiceImplPort();
        int result = service.add(1, 2);
        System.out.println(result);
    }

    /**
     * 通过SOAP发送消息
     * 并在header中传递隐式的头信息
     * 隐式的原因：客户端根据wsdl生成的代码中，接口方法中的参数并没有增加
     * 客户端可以在header中传递信息，服务端可以解析出来
     */
    @org.junit.Test
    public void testHeader() throws Exception {
        String ns = "http://www.example.org/my/";
        String localPart = "MyServiceImplService";
        String address = "http://localhost:7777/ms";
        String prefix = "ns";

        URL wsdlDocumentLocation = new URL(address);
        QName serviceName = new QName(ns,localPart,prefix);
        //创建服务
        Service service = Service.create(wsdlDocumentLocation,serviceName);

        String prot = "MyServiceImplPort";
        QName portName = new QName(ns, prot);
        //创建dispatcher
        Dispatch<SOAPMessage> dispatcher =
                service.createDispatch(portName,SOAPMessage.class,Service.Mode.MESSAGE);

        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        SOAPHeader header = envelope.getHeader();
        SOAPBody body = envelope.getBody();
        if(header==null)
            header = envelope.addHeader();

        //添加header
        String hearderLoaclPart = "license";
        QName headerQName = new QName(ns, hearderLoaclPart, prefix);
        SOAPHeaderElement headerEle = header.addHeaderElement(headerQName);
        headerEle.setValue("this is 隐式头消息");

        //添加body
        //指名访问的方法名:add
        String bodyLoaclPart = "add";
        QName bodyQName = new QName(ns, bodyLoaclPart, prefix);
        SOAPBodyElement bodyEle = body.addBodyElement(bodyQName);
        bodyEle.addChildElement("a").setValue("99");
        bodyEle.addChildElement("b").setValue("101");

        message.writeTo(System.out);
        System.out.println("\n invoking...");

        SOAPMessage retMsg = dispatcher.invoke(message);
        retMsg.writeTo(System.out);

    }
}