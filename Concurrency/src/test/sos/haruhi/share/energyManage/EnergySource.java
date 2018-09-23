package sos.haruhi.share.energyManage;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 手机电源管理功能
 */
public class EnergySource {
    private int useageCount = 0;    // 使用次数
    private final int MAXLEVEL = 100;
    private int level = MAXLEVEL;   // 电池电量
    private int usage = 0;         // 电池用量
    /**
     * 读写锁
     */
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    // 计划任务，用户电池的充放电操作
    private static final ScheduledExecutorService schedule
            = new ScheduledThreadPoolExecutor(20);
    private ScheduledFuture<?> replenishTask;   // 重新装满

    private EnergySource(){}

    private void init(){
        // 固定频率执行任务
        replenishTask = schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                replentish();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static synchronized EnergySource create(){
        EnergySource energySource = new EnergySource();
        energySource.init();
        return energySource;
    }

    /**
     * 放电
     * @param units 用电量
     * @return
     */
    public boolean useEnergy(final long units){
        rwlock.writeLock().lock();
        try {
            if(level > 0 && level >= units){
                level -= units;
                usage += units;
                return true;
            }else{
                return false;
            }
        } finally {
            rwlock.writeLock().unlock();
            System.out.println("useEnergy:" + usage);
        }
    }

    /**
     * 充电
     */
    private void replentish(){
        rwlock.writeLock().lock();
        try {
            if(level < MAXLEVEL) {
                level++;
            }else{
                replenishTask.cancel(false);
            }
        } finally {
            rwlock.writeLock().unlock();
            System.out.println("replentish Level:" + this.level);
        }
    }

    public static void main(String[] args) {
        EnergySource energySource = EnergySource.create();
        energySource.useEnergy(4);
        System.out.println("end");
    }
}
