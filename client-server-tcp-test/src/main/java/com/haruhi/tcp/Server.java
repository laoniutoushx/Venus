package com.haruhi.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SuzumiyaHaruhi on 2017/7/25.
 */
public class Server {
    private final static int PORT = 2012;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("client-server-tcp-ws listening on port " + PORT);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String temp = null;
            String info = "";
            while ((temp = reader.readLine()) != null) {
                info += temp;
            }
            System.out.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
