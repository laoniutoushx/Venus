package sos.haruhi.ws;

import sos.haruhi.ws.service.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class MyServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws", new UserServiceImpl());
    }
}
