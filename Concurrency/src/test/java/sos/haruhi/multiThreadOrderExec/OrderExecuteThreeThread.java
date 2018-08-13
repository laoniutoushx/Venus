package sos.haruhi.multiThreadOrderExec;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 *
 * I. 不加锁，逻辑控制版本
 */
public class OrderExecuteThreeThread implements Runnable {
    private String threadName;
    private int count = 0;
    public static AtomicInteger totalCount = new AtomicInteger(0);
    public static String nextThread = "A";

    public OrderExecuteThreeThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while(OrderExecuteThreeThread.totalCount.get() != 75){
            if(threadName.equals(OrderExecuteThreeThread.nextThread)){

                if("A".equals(this.threadName)){
                    System.out.println("A");
                }
                if("B".equals(this.threadName)){
                    System.out.println("B");
                }
                if("C".equals(this.threadName)){
                    System.out.println("C");
                }
                this.count++;
                OrderExecuteThreeThread.totalCount.addAndGet(1);
                if(this.count == 1){
                    this.count = 0;
                    if("A".equals(OrderExecuteThreeThread.nextThread)){
                        OrderExecuteThreeThread.nextThread = "B";
                    }else if("B".equals(OrderExecuteThreeThread.nextThread)){
                        OrderExecuteThreeThread.nextThread = "C";
                    }else if("C".equals(OrderExecuteThreeThread.nextThread)){
                        OrderExecuteThreeThread.nextThread = "A";
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new OrderExecuteThreeThread("A")).start();
        new Thread(new OrderExecuteThreeThread("B")).start();
        new Thread(new OrderExecuteThreeThread("C")).start();
    }
}
