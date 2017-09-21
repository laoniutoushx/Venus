import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

/**
 * Created by SuzumiyaHaruhi on 2017/9/12.
 */
public class WebSocket implements Runnable {
    public static void main(String[] args) {

        new Thread(new WebSocket()).start();
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String haruhi = JSON.toJSONString(new Pojo());
        while (true) {

            try {
                Socket socket = new Socket("10.10.90.17", 8888);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                out.println(haruhi);
                out.flush();
                //执行相应的关闭操作
                socket.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
