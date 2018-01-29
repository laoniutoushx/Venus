package com.haruhi;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

public class TestSoap {
    final private String wsdlUrl = "http://localhost:8888/ws?wsdl";
    final private String namespace = "http://haruhi.com/";
    /**
     * 手工创建 SOAP 消息
     *
     * SOAP 结构
     *
     * SOAP document
     * -- SOAPHeader
     *   -- 头部信息（可有）
     * -- SOAPBody
     *   -- 请求体信息
     * --AttachmentPart （附件信息）二进制
     *   -- MIMI Header 多媒体头
     *   -- Content (XML or non-XML)
     *
     * @throws SOAPException
     */
    @Test
    public void test01() throws SOAPException, IOException {
        // 创建消息工厂
        MessageFactory factory = MessageFactory.newInstance();
        // 创建 soap message
        SOAPMessage message = factory.createMessage();
        // 创建 soapPart
        SOAPPart soapPart = message.getSOAPPart();
        // 获取 SOAPEnvelop soap 信封
        SOAPEnvelope envelope = soapPart.getEnvelope();
        // 通过 soap 信封获取 body  的信息
        SOAPBody body = envelope.getBody();
        // 根据 QName 创建相应节点 （QName 是一种带有相应命名空间的节点）
        QName qName = /** <ws:add xlnms="http://xyz.haruhi.sos" /> **/
                new QName("http://xyz.haruhi.sos", "add", "ws");
        /** 以下设置会转码 **/
        //body.addBodyElement(qName).setValue("<a>1</a><b>3</b>");
        SOAPBodyElement element = body.addBodyElement(qName);
        element.addChildElement("a", "ws").setValue("234");
        element.addChildElement("b", "ws").setValue("456");
        // 打印消息信息
        message.writeTo(System.out);
    }

    /**
     * soap请求提交到服务器（message）
     * @throws SOAPException
     * @throws IOException
     */
    @Test
    public void test02() throws SOAPException, IOException {
        // 创建服务 (Service)
        URL url = new URL(wsdlUrl);
        QName qName = new QName(namespace, "MyServiceImplService");
        Service service = Service.create(url, qName);
        // 创建 Dispatch
        Dispatch<SOAPMessage> dispatch = service.createDispatch(
                new QName(namespace, "MyServiceImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
        // 创建 SOAPMessage
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        // 获取信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        // 获取 body
        SOAPBody body = envelope.getBody();

        // 创建 QName 来制定消息中传递的信息
        QName ename = new QName(namespace, "add", "ws");
        SOAPBodyElement ele = body.addBodyElement(ename);
        ele.addChildElement("a").setValue("33");
        ele.addChildElement("b").setValue("44");

        message.writeTo(System.out);
        System.out.println("\n invoking...");
        // 通过 dispatch 传递消息
        SOAPMessage response = dispatch.invoke(message);
        response.writeTo(System.out);

        System.out.println();

        // 将响应的消息转化为 dom 对象
        Document document = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        String result = document.getElementsByTagName("addResult").item(0).getTextContent();
        System.out.println(result);
    }

    /**
     * soap请求提交到服务器（负载）
     * @throws SOAPException
     * @throws IOException
     */
    @Test
    public void test03() throws SOAPException, IOException, JAXBException, TransformerException, XPathExpressionException {
        // 创建服务 (Service)
        URL url = new URL(wsdlUrl);
        QName qName = new QName(namespace, "MyServiceImplService");
        Service service = Service.create(url, qName);
        // 创建 Dispatch （通过元数据方式传递）
        Dispatch<Source> dispatch = service.createDispatch(
                new QName(namespace, "MyServiceImplPort"), Source.class, Service.Mode.PAYLOAD);

        // 创建 service 用户对象  对应的 xml
        User user = new User(4, "ww", "王五", "wangwu");

        JAXBContext ctx = JAXBContext.newInstance(User.class);
        Marshaller mars = ctx.createMarshaller();

        // 设置默认显示 document 头，false
        mars.setProperty(Marshaller.JAXB_FRAGMENT, true);

        StringWriter sw = new StringWriter();
        mars.marshal(user, sw);
        System.out.println(sw);

        // 封装 相应的额 part addUser
        String payload = "<nn:addUser xmlns:nn=\"" + namespace + "\">"
                + sw.toString() + "</nn:addUser>";
        System.out.println("payload:" + payload);
        StreamSource source = new StreamSource(new StringReader(payload));

        // 通过 dispatch 传递 payload
        Source resp = dispatch.invoke(source);

        // 处理响应信息
        System.out.println("返回类型" + resp.getClass());


        // 将 Source 转换为 dom 进行操作
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        DOMResult dom = new DOMResult();
        trans.transform(resp, dom);

        // 获取节点
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.evaluate("//user", dom.getNode(), XPathConstants.NODESET);

        System.out.println(nodeList.item(0).getNodeName());

        // xml to javaBean
        User temp = (User) ctx.createUnmarshaller().unmarshal(nodeList.item(0));
        System.out.println(temp.toString());
    }

    /**
     * soap 请求方法，不带参数（message）
     * @throws SOAPException
     * @throws IOException
     */
    @Test
    public void test04() throws SOAPException, IOException, JAXBException {
        // 创建服务 (Service)
        URL url = new URL(wsdlUrl);
        QName qName = new QName(namespace, "MyServiceImplService");
        Service service = Service.create(url, qName);
        // 创建 Dispatch
        Dispatch<SOAPMessage> dispatch = service.createDispatch(
                new QName(namespace, "MyServiceImplPort"),
                SOAPMessage.class, Service.Mode.MESSAGE);
        // 创建 SOAPMessage
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        // 获取信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        // 获取 body
        SOAPBody body = envelope.getBody();

        // 获取 Header， 处理 Header 信息
        SOAPHeader header = envelope.getHeader();
        if(header == null)
            header = envelope.addHeader();
        QName qNameH  = new QName(namespace, "authInfo", "ws");
        header.addHeaderElement(qNameH).setValue("aabbcc");

        // 创建 QName 来制定消息中传递的信息
        QName ename = new QName(namespace, "lists", "ws");

        SOAPBodyElement ele = body.addBodyElement(ename);
        message.writeTo(System.out);
        System.out.println("\n invoking...");
        // 通过 dispatch 传递消息
        SOAPMessage response = dispatch.invoke(message);
        response.writeTo(System.out);

        System.out.println();

        // 将响应的消息转化为 dom 对象
        Document document = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        NodeList nl = document.getElementsByTagName("service");

        JAXBContext ctx = JAXBContext.newInstance(User.class);
        for(int i = 0; i < nl.getLength(); i++){
            Node node = nl.item(i);
            User u = (User) ctx.createUnmarshaller().unmarshal(node);
            System.out.println(u.toString());
        }
    }

    /**
     * soap 处理错误信息（message）
     * @throws SOAPException
     * @throws IOException
     */
    @Test
    public void test05() throws SOAPException, IOException, JAXBException {
        // 创建服务 (Service)
        URL url = new URL(wsdlUrl);
        QName qName = new QName(namespace, "MyServiceImplService");
        Service service = Service.create(url, qName);
        // 创建 Dispatch
        Dispatch<SOAPMessage> dispatch = service.createDispatch(
                new QName(namespace, "MyServiceImplPort"),
                SOAPMessage.class, Service.Mode.MESSAGE);
        // 创建 SOAPMessage
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        // 获取信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        // 获取 body
        SOAPBody body = envelope.getBody();

        // 创建 QName 来制定消息中传递的信息
        QName ename = new QName(namespace, "login", "ws");

        SOAPBodyElement ele = body.addBodyElement(ename);
        ele.addChildElement("username").setValue("kkk");
        ele.addChildElement("password").setValue("kkk");

        message.writeTo(System.out);
        System.out.println("\n invoking...");
        // 通过 dispatch 传递消息
        SOAPMessage response = dispatch.invoke(message);
        response.writeTo(System.out);

        System.out.println();


    }
}
