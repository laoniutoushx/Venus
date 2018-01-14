package com.haruhi.another;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws?wsdl", new MathServiceImpl());
    }
}
