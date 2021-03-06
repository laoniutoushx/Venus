
package com.haruhi.sos;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMyService", targetNamespace = "http://haruhi.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMyService {


    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "addResult", targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.AddResponse")
    @Action(input = "http://haruhi.com/IMyService/addRequest", output = "http://haruhi.com/IMyService/addResponse")
    public int add(
        @WebParam(name = "a", targetNamespace = "")
        int a,
        @WebParam(name = "b", targetNamespace = "")
        int b);

    /**
     * 
     * @return
     *     returns java.util.List<com.haruhi.sos.User>
     */
    @WebMethod
    @WebResult(name = "service", targetNamespace = "")
    @RequestWrapper(localName = "list", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.ListResponse")
    @Action(input = "http://haruhi.com/IMyService/listRequest", output = "http://haruhi.com/IMyService/listResponse")
    public List<User> list();

    /**
     * 
     * @param user
     */
    @WebMethod
    @RequestWrapper(localName = "addUser", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.AddUserResponse")
    @Action(input = "http://haruhi.com/IMyService/addUserRequest", output = "http://haruhi.com/IMyService/addUserResponse")
    public void addUser(
        @WebParam(name = "service", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<User> user);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns com.haruhi.sos.User
     */
    @WebMethod
    @WebResult(name = "service", targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://haruhi.com/", className = "com.haruhi.sos.LoginResponse")
    @Action(input = "http://haruhi.com/IMyService/loginRequest", output = "http://haruhi.com/IMyService/loginResponse")
    public User login(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param parameters
     * @param authInfo
     * @return
     *     returns com.haruhi.sos.ListsResponse
     */
    @WebMethod
    @WebResult(name = "listsResponse", targetNamespace = "http://haruhi.com/", partName = "result")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://haruhi.com/IMyService/listsRequest", output = "http://haruhi.com/IMyService/listsResponse")
    public ListsResponse lists(
        @WebParam(name = "lists", targetNamespace = "http://haruhi.com/", partName = "parameters")
        Lists parameters,
        @WebParam(name = "authInfo", targetNamespace = "http://haruhi.com/", header = true, partName = "authInfo")
        String authInfo);

}
