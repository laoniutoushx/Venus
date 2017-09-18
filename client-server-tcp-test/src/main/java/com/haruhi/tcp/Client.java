package com.haruhi.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by SuzumiyaHaruhi on 2017/7/23.
 */
public class Client {

    private final static String IP = "127.0.0.1";
    private final static int PORT = 2012;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, PORT);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 系统输入流
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while(true){
                String userInput = br.readLine();
                if (userInput.equals("quit")) break;
                byte[] data = userInput.getBytes("UTF-8");
                out.print(data);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
