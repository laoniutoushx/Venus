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
 * @Time 2018/1/1 21:45:49
 * @Version v1.0
 */
@WebService(endpointInterface = "com.haruhi.ws.IService")
public class ServiceImpl implements IService {

    public int add(int a, int b) {
        System.out.println("a + b = " + (a + b));
        return a + b;
    }

    public int min(int a, int b) {
        System.out.println("a - b = " + (a - b));
        return a - b;
    }
}
