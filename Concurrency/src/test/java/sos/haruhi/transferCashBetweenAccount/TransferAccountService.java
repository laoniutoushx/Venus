package sos.haruhi.transferCashBetweenAccount;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TransferAccountService {
    public boolean transfer(final TransferAccount from, final TransferAccount to, final int amount) throws InterruptedException {
        final TransferAccount[] accounts = new TransferAccount[]{to, from};
        Arrays.sort(accounts);  //  排序账户，确保获取锁的顺序

        try {
            if(accounts[0].monitor.tryLock(1, TimeUnit.SECONDS)){
                try {
                    if(accounts[1].monitor.tryLock(1, TimeUnit.SECONDS)){
                        if(from.withdraw(amount)){
                            to.deposit(amount);
                            return true;
                        }else{
                            return false;
                        }
                    }
                } finally {
                    accounts[1].monitor.unlock();
                }
            }
        } finally {
            accounts[0].monitor.unlock();
        }
        throw new RuntimeException("Unable to acquire locks on the accounts");
    }

    public static void main(String[] args) throws InterruptedException {
        TransferAccount from = new TransferAccount(100);
        TransferAccount to = new TransferAccount(100);
        new TransferAccountService().transfer(from, to, 100);
        new TransferAccountService().transfer(from, to, 100);
        new TransferAccountService().transfer(to, from, 100);
        System.out.println(from.getBalance());
        System.out.println(to.getBalance());
    }
}
