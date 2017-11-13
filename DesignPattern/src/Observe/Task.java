package Observe;

/**
 * Description Observe in Venus
 * Created by SuzumiyaHaruhi on 2017/11/12.
 */
public class Task implements Runnable {
    private static boolean running = true;
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
        while(running){

        }
    }
}
