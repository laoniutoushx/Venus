package com.haruhi.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by SuzumiyaHaruhi on 2017/7/23.
 */
public class Client {
    // discard 的端口为9
    private static final int DEFAULT_PORT = 9;

    public static void main(String[] args) {// TODO Auto-generated method stub
        String hostname = "localhost";
        int port = DEFAULT_PORT;
        try {
            InetAddress server = InetAddress.getByName(hostname);
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in)); // 系统输入流
            // 创建UDP客户端
            DatagramSocket client = new DatagramSocket();
            while (true) {
                String inline = userIn.readLine();
                if (inline.indexOf('.') != -1) break;
                byte[] data = inline.getBytes("UTF-8");

                // 创建一个数据报
                DatagramPacket thepacket = new DatagramPacket(data, data.length, server, port);
                // 发送数据报
                client.send(thepacket);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
