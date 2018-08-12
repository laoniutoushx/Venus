package sos.haurhi.multiThreadOrderExec;

public class OrderExecThreadLockedFinal implements Runnable {

    private Type type;
    private OrderExecThreadLockedFinal prev;
    private int count = 0;

    public OrderExecThreadLockedFinal(Type type) {
        this.type = type;
    }

    @Override
    public void run() {
        while(count < 3){
            synchronized (prev){
                synchronized (this){
                    System.out.println(this.type.name());
                    count++;
                    this.notifyAll();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (this){
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OrderExecThreadLockedFinal A = new OrderExecThreadLockedFinal(Type.A);
        OrderExecThreadLockedFinal B = new OrderExecThreadLockedFinal(Type.B);
        OrderExecThreadLockedFinal C = new OrderExecThreadLockedFinal(Type.C);
        A.prev = C;
        B.prev = A;
        C.prev = B;
        new Thread(A).start();
        Thread.sleep(10);
        new Thread(B).start();
        Thread.sleep(10);
        new Thread(C).start();
    }
}

enum Type{
    A, B, C
}
