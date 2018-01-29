package com.haruhi.stax;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * XMLStreamReader
 */
public class TestStax {
    /**
     * 输出文档标签
     * @throws XMLStreamException
     */
    @Test
    public void test01() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        while(reader.hasNext()){
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                System.out.println(reader.getName());
            }
            else if(type == XMLStreamConstants.CHARACTERS){
                System.out.println(reader.getText().trim());
            }
            else if(type == XMLStreamConstants.END_ELEMENT){
                System.out.println("/" + reader.getName());
            }
        }
    }

    /**
     * 输出属性
     * @throws XMLStreamException
     */
    @Test
    public void test02() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        while(reader.hasNext()){
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                String name = reader.getName().toString();
                if(name.equals("book")){
                    System.out.println(reader.getAttributeName(0) + ":" + reader.getAttributeValue(0));
                }
            }
        }
    }

    /**
     * 判断节点类型
     * 输出价格
     * @throws XMLStreamException
     */
    @Test
    public void test03() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        while(reader.hasNext()){
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                String name = reader.getName().toString();
                if(name.equals("title")){
                    System.out.print(reader.getElementText() + ":");
                }
                if(name.equals("price")){
                    System.out.print(reader.getElementText() + "\n");
                }
            }
        }
    }

    /**
     * 基于迭代模型
     * @throws XMLStreamException
     */
    @Test
    public void test04() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        XMLEventReader reader = factory.createXMLEventReader(is);
        while(reader.hasNext()){
            // 通过 Event 获取是否是某种节点
            XMLEvent event = reader.nextEvent();
            if(event.isStartElement()){
                // 通过 Event.as 转换节点
                String name = event.asStartElement().getName().toString();
                if(name.equals("title")){

                }
            }
        }
    }

    /**
     * 基于过滤器
     * @throws XMLStreamException
     */
    @Test
    public void test05() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        XMLEventReader reader = factory.createFilteredReader(factory.createXMLEventReader(is), new EventFilter() {
            @Override
            public boolean accept(XMLEvent event) {
                if(event.isStartElement()){
                    String name = event.asStartElement().getName().toString();
                    if("title".equals(name) || "price".equals(name)){
                        return true;
                    }
                }
                return false;
            }
        });
        int number = 0;
        while(reader.hasNext()){
            // 通过 Event 获取是否是某种节点
            XMLEvent event = reader.nextEvent();
            String name = event.asStartElement().getName().toString();
            if("title".equals(name) || "price".equals(name)){
                System.out.print(reader.getElementText() + (number % 2 != 0 ? "\n" : ":"));
            }
            number ++;
        }
        System.out.println(number);
    }

    /**
     * 使用 xPath 读入
     * @throws XMLStreamException
     */
    @Test
    public void test06() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        // 创建文档处理对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 通过documentBuilder 创建doc的文档对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(is);
        // 创建 xpath 对象
        XPath xPath = XPathFactory.newInstance().newXPath();
        // 查询参数，文档对象，返回类型
        NodeList list = (NodeList) xPath.evaluate("//book[@category='WEB']", document, XPathConstants.NODESET);
        for(int i = 0; i < list.getLength(); i++){
            Element element = (Element) list.item(i);
            System.out.println(element.getElementsByTagName("title").item(0).getTextContent());
        }
    }

    /**
     * 创建 xml write
     * @throws XMLStreamException
     */
    @Test
    public void test07() throws XMLStreamException {
        XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
        xsw.writeStartDocument("UTF-8", "1.0");
        String ns = "http://abc.haruhi.sos";
        xsw.writeStartElement("ns","person", ns);
        xsw.writeStartElement(ns, "id");
        xsw.writeCharacters("1");
        xsw.writeEndElement();
        xsw.writeEndElement();
        xsw.flush();
        xsw.close();

    }

    /**
     * 用 transform 修改某个节点
     * @throws XMLStreamException
     */
    @Test
    public void test08() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException, TransformerException {
        // 找到节点

        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = TestStax.class.getClassLoader().getResourceAsStream("com\\haruhi\\stax\\books.xml");
        // 创建文档处理对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 通过documentBuilder 创建doc的文档对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(is);
        // 创建 xpath 对象
        XPath xPath = XPathFactory.newInstance().newXPath();
        // 查询参数，文档对象，返回类型
        NodeList list = (NodeList) xPath.evaluate("//book[title='Learning XML']", document, XPathConstants.NODESET);

        // book 元素  下 price 元素
        Element element = (Element) ((Element) list.item(0)).getElementsByTagName("price").item(0);
        // 修改节点

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        element.setTextContent("256.34");
        transformer.transform(new DOMSource(document), new StreamResult(System.out));

    }
}
