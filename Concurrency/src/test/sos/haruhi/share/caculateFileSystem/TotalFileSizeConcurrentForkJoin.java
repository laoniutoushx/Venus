package sos.haruhi.share.caculateFileSystem;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 使用 java fork-join api 调度线程重复利用
 */
public class TotalFileSizeConcurrentForkJoin {
    private static final ForkJoinPool pool = new ForkJoinPool();

    /**
     * 递归任务
     */
    private static class FileSizeFinder extends RecursiveTask<Long>{
        final File file;
        public FileSizeFinder(final File file){
            this.file = file;
        }
        @Override
        protected Long compute() {
            long size = 0;
            if(file.isFile()){
                size += file.length();
            }else{
                File[] children = file.listFiles();
                if(children != null){
                    List<ForkJoinTask<Long>> tasks = new ArrayList<>();
                    for(File child:children){
                        if(child.isFile()){
                            size += child.length();
                        }else{
                            // 为每个文件夹 新建任务实例
                            tasks.add(new FileSizeFinder(child));
                        }
                    }

                    for(final ForkJoinTask<Long> task:this.invokeAll(tasks)){
                        size += task.join();
                    }

                }
            }
            return size;
        }
    }

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final long total = pool.invoke(new FileSizeFinder(new File("S:\\")));
        final long end = System.currentTimeMillis();
        System.out.println("Total Size:" + total);
        System.out.println("Time Taken:" + (end - start));
    }
}
