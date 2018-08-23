package sos.haruhi.caculateFileSystem;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用 countDownLatch 与 共享变量
 */
public class TotalFileSizeConcurrentWLatch {
    private ExecutorService service;
    final private AtomicLong pendingFileVisits = new AtomicLong();
    final private AtomicLong totalSize = new AtomicLong();
    final private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 目录扫描
     * @param file  目录
     */
    private void updateTotalSizeOfFilesInDir(final File file){
        long fileSize = 0;
        if(file.isFile()){
            fileSize = file.length();
        }else{
            final File[] children = file.listFiles();
            if(children != null){
                for(final File child:children){
                    if (child.isFile()){
                        fileSize += child.length();
                    }else{
                        pendingFileVisits.incrementAndGet();
                        service.execute(new Runnable() {
                            @Override
                            public void run() {
                                updateTotalSizeOfFilesInDir(child);
                            }
                        });
                    }
                }
            }
        }
        totalSize.addAndGet(fileSize);
        if(pendingFileVisits.decrementAndGet() == 0) latch.countDown(); // 线程条件判断
    }

    private long getTotalSizeOfFile(final String fileName) throws InterruptedException {
        service = Executors.newFixedThreadPool(20);
        pendingFileVisits.incrementAndGet();

        try {
            updateTotalSizeOfFilesInDir(new File(fileName));
            latch.await(100, TimeUnit.SECONDS);     // 挂起当前主线程，直到 latch = 0
            return totalSize.longValue();
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        final long total = new TotalFileSizeConcurrentWLatch().getTotalSizeOfFile("S:\\");
        final long end = System.currentTimeMillis();
        System.out.println("Total Size:" + total);
        System.out.println("Time taken:" + (end - start));

    }
}
