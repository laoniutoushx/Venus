package Observe;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Description PACKAGE_NAME in Venus
 * Created by SuzumiyaHaruhi on 2017/10/18.
 */
public class Publisher{
    private static ConcurrentLinkedQueue<Event> subcribList = new ConcurrentLinkedQueue<Event>();
    public void sent(Event e){

    }

    public static void main(String[] args) {
        int i = 2;
        try {
            Thread.currentThread().sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i<<1);
    }
}
