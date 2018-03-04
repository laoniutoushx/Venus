package sos.haruhi.com;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.MTOM;

public class MyServerBin {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws", new MyServiceImpl());
    }
}
