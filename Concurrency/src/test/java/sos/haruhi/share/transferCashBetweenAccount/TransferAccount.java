package sos.haruhi.share.transferCashBetweenAccount;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现两个账户间转账
 */
public class TransferAccount implements Comparable<TransferAccount> {
    private int balance;
    public final Lock monitor = new ReentrantLock();

    public TransferAccount(final int initialBalance){
        this.balance = initialBalance;
    }

    public int compareTo(final TransferAccount other){
        return new Integer(hashCode()).compareTo(other.hashCode());
    }

    public int getBalance(){
        return this.balance;
    }
    /**
     * 保证金
     * @param amount    金额
     */
    public void deposit(final int amount){
        monitor.lock();
        try {
            if(amount > 0) balance += amount;
        } finally {
            monitor.unlock();
        }

    }

    public boolean withdraw(final int amount){
        try {
            monitor.lock();
            if(amount > 0 && balance >= amount){
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            monitor.unlock();
        }

    }


}
