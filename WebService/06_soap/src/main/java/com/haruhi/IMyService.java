package com.haruhi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IMyService {
    @WebMethod(operationName = "add")
    @WebResult(name = "addResult") int add(@WebParam(name = "a") int a, @WebParam(name="b") int b);

    @WebMethod(operationName = "addUser")
    @WebResult(name = "user") User addUser(@WebParam(name = "user") User user);

    @WebMethod(operationName = "login")
    @WebResult(name = "user") User login(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) throws UserException;

    @WebMethod(operationName = "list")
    @WebResult(name = "user") List<User> list();

    @WebMethod(operationName = "lists")
    @WebResult(name = "user") List<User> lists(@WebParam(header = true, name = "authInfo") String authInfo);
}
