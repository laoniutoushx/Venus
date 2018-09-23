package sos.haruhi.stm;


import org.multiverse.api.references.TxnLong;

import java.util.Date;

import static org.multiverse.api.StmUtils.atomic;
import static org.multiverse.api.StmUtils.newTxnLong;

public class MultiverseTest {

    private final TxnLong balance;//需要注意的是在事务中，java原生的类型都有其包装类型。这些类型只能在事务中进行访问。

    public MultiverseTest(int balance) {
        this.balance = newTxnLong(balance);
    }

    public void incBalance(final int amount, final Date date, final int j) {
        new Thread(new Runnable() {
            public void run() {
                atomic(new Runnable() { //atomic将该操作原子化，事务开始执行
                    int count = 0;
                    int idx = j;
                    public void run() {
                        if (count == 0) {
                            System.out.println(idx + " first");
                        } else {
                            System.out.println(idx + " retry " + count); // 记录重试的次数
                        }
                        count++;

                        if (balance.get() < 0) {
                            throw new IllegalStateException("Not enough money");
                        }

//                        long i;
//                        for (i = 0; i < Integer.MAX_VALUE / 20; i++) {
//                        }

                        balance.increment(amount);

                    }
                });
            }
        }).start();

    }

    public void print() {
        atomic(new Runnable() {

            public void run() {
                System.out.println(balance.get());
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("MUL");
        final long start = System.currentTimeMillis();
        // 获取系统硬件提供 cpu 核心数
        int process = Runtime.getRuntime().availableProcessors();

        //初始化账户
        final MultiverseTest multiverseTest = new MultiverseTest(1000);

        //启动一定数量的线程对账户进行操作哦
        for(int i = 0; i < process * 2; i++) {
            multiverseTest.incBalance(1, new Date(), i);
        }

        // 增加shutdown hook，在所有线程结束后，主线程结束前将账户值打印
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                multiverseTest.print();
                System.out.println(System.currentTimeMillis() - start);
            }
        }));
    }
}