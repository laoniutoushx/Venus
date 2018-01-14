package com.haruhi.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.ws</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/1 21:45:11
 * @Version v1.0
 */
@WebService
public interface IService {
    @WebMethod(operationName = "add")
    @WebResult(name = "addResult")int add(@WebParam(name = "a")int a,@WebParam(name = "b")int b);
    int min(int a, int b);
    @WebMethod(operationName = "login")
    @WebResult(name = "loginResult")User login(@WebParam(name = "username")String username, @WebParam(name = "password")String password);
}
