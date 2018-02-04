
package sos.haruhi.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sos.haruhi.ws.client package. 
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

    private final static QName _AddResponse_QNAME = new QName("http://sos.haruhi.ws/test/", "addResponse");
    private final static QName _DelResponse_QNAME = new QName("http://sos.haruhi.ws/test/", "delResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://sos.haruhi.ws/test/", "loginResponse");
    private final static QName _Add_QNAME = new QName("http://sos.haruhi.ws/test/", "add");
    private final static QName _License_QNAME = new QName("http://sos.haruhi.ws/test/", "license");
    private final static QName _ListResponse_QNAME = new QName("http://sos.haruhi.ws/test/", "listResponse");
    private final static QName _List_QNAME = new QName("http://sos.haruhi.ws/test/", "list");
    private final static QName _Login_QNAME = new QName("http://sos.haruhi.ws/test/", "login");
    private final static QName _Del_QNAME = new QName("http://sos.haruhi.ws/test/", "del");
    private final static QName _UserException_QNAME = new QName("http://sos.haruhi.ws/test/", "UserException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sos.haruhi.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link License }
     * 
     */
    public License createLicense() {
        return new License();
    }

    /**
     * Create an instance of {@link DelResponse }
     * 
     */
    public DelResponse createDelResponse() {
        return new DelResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Del }
     * 
     */
    public Del createDel() {
        return new Del();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "delResponse")
    public JAXBElement<DelResponse> createDelResponse(DelResponse value) {
        return new JAXBElement<DelResponse>(_DelResponse_QNAME, DelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link License }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "license")
    public JAXBElement<License> createLicense(License value) {
        return new JAXBElement<License>(_License_QNAME, License.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Del }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "del")
    public JAXBElement<Del> createDel(Del value) {
        return new JAXBElement<Del>(_Del_QNAME, Del.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sos.haruhi.ws/test/", name = "UserException")
    public JAXBElement<UserException> createUserException(UserException value) {
        return new JAXBElement<UserException>(_UserException_QNAME, UserException.class, null, value);
    }

}
