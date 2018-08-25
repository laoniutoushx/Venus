package sos.haruhi.share.caculateFileSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 并发计算文件目录大小
 * 为每个目录开启一个线程，对于目录结构较深的目录会线程死锁
 */
public class TotalFileSizeConcurrent {
    private long getTotalSizeOfFilesInDir(final ExecutorService service, final File file) throws InterruptedException, ExecutionException, TimeoutException {
        if(file.isFile()) return file.length();

        long total = 0;
        final File[] subDirs = file.listFiles();

        if(subDirs != null){
            final List<Future<Long>> partialTotalFutures =
                    new ArrayList<>();
            for(final File subDir:subDirs){
                partialTotalFutures.add(service.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return getTotalSizeOfFilesInDir(service, subDir);
                    }
                }));
            }

            for(final Future<Long> partialTotalFuture:partialTotalFutures){
                total += partialTotalFuture.get(100, TimeUnit.SECONDS);
            }
        }

        return total;
    }

    private long getTotalSizeOfFile(final String fileName) throws InterruptedException, ExecutionException, TimeoutException {
        final ExecutorService service = Executors.newFixedThreadPool(50);
        try {
            return getTotalSizeOfFilesInDir(service, new File(fileName));
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long startTime = System.currentTimeMillis();
        long size = new TotalFileSizeConcurrent().getTotalSizeOfFile("S:\\apache-maven-3.5.2");
        System.out.println(size);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
