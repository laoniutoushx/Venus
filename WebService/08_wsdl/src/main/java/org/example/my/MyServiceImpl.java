package org.example.my;

import javax.jws.WebService;
/**
 * 实现类
 * 指定wsdlLocation="META-INF/wsdl/my.wsdl"，使用本地以及编写好的wsdl文件
 */
@WebService(endpointInterface="org.example.my.IMyservice",
        targetNamespace = "http://www.example.org/my/",
        wsdlLocation="META-INF/wsdl/my.wsdl")
public class MyServiceImpl implements IMyservice {

    @Override
    public int add(int a, int b, String license) {
        //如果客户端没有传递头信息，则license为null
        System.out.println("MyServiceImpl.add() "+license);
        return a+b;
    }

}