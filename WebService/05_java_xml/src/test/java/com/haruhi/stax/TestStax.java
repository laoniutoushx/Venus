package com.haruhi.stax;

import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

/**
 * XMLStreamReader
 */
public class TestStax {
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
                System.out.println(reader.getName());
            }
        }
    }
}
