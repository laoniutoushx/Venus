package sos.haruhi.caculateFileSystem;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用阻塞队列来在 线程之间 传递数据
 */
public class TotalFileSizeConcurrentWQueue {
    private ExecutorService service;
    final private BlockingQueue<Long> fileSizes = new ArrayBlockingQueue<Long>(500);
    final AtomicLong pendingFileVisits = new AtomicLong();

    private void startExploreDir(final File file){
        pendingFileVisits.incrementAndGet();
        service.execute(new Runnable() {
            @Override
            public void run() {
                exploreDir(file);
            }
        });
    }

    private void exploreDir(final File file){
        long fileSize = 0;
        if(file.isFile()){
            fileSize += file.length();
        }else{
            final File[] children = file.listFiles();
            if(children != null){
                for(final File child:children){
                    if(child.isFile()){
                        fileSize += child.length();
                    }else{
                        startExploreDir(child);
                    }
                }
            }
        }

        try {
            fileSizes.put(fileSize);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pendingFileVisits.decrementAndGet();
    }

    private long getTotalSizeOfDir(final String filePath) throws InterruptedException {
        service = Executors.newFixedThreadPool(20);
        try {
            startExploreDir(new File(filePath));
            long totalSize = 0;
            while(pendingFileVisits.get() > 0 || fileSizes.size() > 0){
                final Long size = fileSizes.poll(10, TimeUnit.SECONDS);
                totalSize += size;
            }
            return totalSize;
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        final long total = new TotalFileSizeConcurrentWQueue().getTotalSizeOfDir("S:\\");
        final long end = System.currentTimeMillis();
        System.out.println("Total Size:" + total);
        System.out.println("Time Taken:" + (end - start));
    }
}
