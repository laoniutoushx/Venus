package org.example.my;

import javax.xml.ws.Endpoint;

public class MyServer {
    public static void main(String[] args) {
        String address = "http://localhost:7777/ms";
        IMyservice implementor = new MyServiceImpl();
        Endpoint.publish(address, implementor);
    }

}