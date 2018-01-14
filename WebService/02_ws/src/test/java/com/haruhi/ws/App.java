package com.haruhi.ws;

import javax.xml.ws.Endpoint;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.ws</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/1 21:44:47
 * @Version v1.0
 */
public class App {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws?wsdl", new ServiceImpl());
    }
}
