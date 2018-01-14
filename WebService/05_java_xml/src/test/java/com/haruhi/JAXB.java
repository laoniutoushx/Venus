package com.haruhi;
import org.junit.*;
import com.haruhi.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class JAXB {

    /**
     * bean to xml
     * @throws JAXBException
     */
    @Test
    public void test01() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = ctx.createMarshaller();
        Student stu = new Student(22, "张三", 20, new Classroom(1, "10计算机应用技术", 2010));
        marshaller.marshal(stu, System.out);
    }

    /**
     * xml to bean
     * @throws JAXBException
     */
    @Test
    public void test02() throws JAXBException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>20</age><classroom><grade>2010</grade><id>1</id><name>10计算机应用技术</name></classroom><id>22</id><name>张三</name></student>";
        JAXBContext ctx = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        Student stu = (Student) unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(stu.getClassroom().getName());
    }
}
