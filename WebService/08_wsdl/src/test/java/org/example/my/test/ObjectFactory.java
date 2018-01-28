
package org.example.my.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.my.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _License_QNAME = new QName("http://www.example.org/my/", "license");
    private final static QName _Add_QNAME = new QName("http://www.example.org/my/", "add");
    private final static QName _AddResponse_QNAME = new QName("http://www.example.org/my/", "addResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.my.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddType }
     * 
     */
    public AddType createAddType() {
        return new AddType();
    }

    /**
     * Create an instance of {@link AddResponseType }
     * 
     */
    public AddResponseType createAddResponseType() {
        return new AddResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/my/", name = "license")
    public JAXBElement<String> createLicense(String value) {
        return new JAXBElement<String>(_License_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/my/", name = "add")
    public JAXBElement<AddType> createAdd(AddType value) {
        return new JAXBElement<AddType>(_Add_QNAME, AddType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/my/", name = "addResponse")
    public JAXBElement<AddResponseType> createAddResponse(AddResponseType value) {
        return new JAXBElement<AddResponseType>(_AddResponse_QNAME, AddResponseType.class, null, value);
    }

}
