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
}
