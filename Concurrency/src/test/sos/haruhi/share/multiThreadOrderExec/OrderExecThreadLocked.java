package sos.haruhi.share.multiThreadOrderExec;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 *
 * I. 通过对象锁来控制
 */
public class OrderExecThreadLocked implements Runnable {

    private ThreadType threadType;
    public static AtomicInteger count = new AtomicInteger(0);

    public OrderExecThreadLocked(ThreadType threadType) {
        this.threadType = threadType;
    }

    @Override
    public void run() {
        while(OrderExecThreadLocked.count.get() < 10){

            synchronized (OrderExecThreadLocked.class){
                System.out.println(this.threadType.name());
                OrderExecThreadLocked.count.getAndAdd(1);
                OrderExecThreadLocked.class.notify();
                try {
                    // 释放锁，挂起当前线程
                    OrderExecThreadLocked.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // 只有获得 对象控制权的线程才可以执行 wait notify notifyAll 操作
        synchronized (OrderExecThreadLocked.class){
            OrderExecThreadLocked.class.notifyAll();
        }
    }

    public static void main(String[] args) {
        new Thread(new OrderExecThreadLocked(ThreadType.A)).start();
        new Thread(new OrderExecThreadLocked(ThreadType.B)).start();
        new Thread(new OrderExecThreadLocked(ThreadType.C)).start();
    }
}

enum ThreadType{
    A,      // 线程 A
    B,      // 线程 B
    C       // 线程 C
}
