package sos.haruhi.caculateFileSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class TotalFileSizeConcurrentAnother {

    class SubDirectoriesAndSize{
        final public long size;
        final public List<File> subDirectories;

        public SubDirectoriesAndSize(final long size, final List<File> subDirectories) {
            this.size = size;
            this.subDirectories = Collections.unmodifiableList(subDirectories);
        }
    }

    /**
     * 给定文件目录作为输入
     * @param rootFile
     * @return  返回包含该目录下所有子目录的列表和目录下所有文件的大小
     */
    public SubDirectoriesAndSize getDirsAndSize(File rootFile){
        long total = 0;
        final List<File> subDirs = new ArrayList<>();
        final File[] children = rootFile.listFiles();
        if(children != null){
            for(final File child:children){
                if(child.isFile()){
                    total += child.length();
                }else{
                    subDirs.add(child);
                }
            }
        }
        return new SubDirectoriesAndSize(total, subDirs);
    }

    /**
     * 对目录启用线程扫描，将改层目录下文件大小及子目录返回，待下个线程继续执行
     * @param file
     * @return  文件大小
     */
    private long getTotalSizeOfFilesInDir(final File file) throws InterruptedException, ExecutionException, TimeoutException {
        final ExecutorService service = Executors.newFixedThreadPool(12);

        try {
            long total = 0;
            final List<File> directories = new ArrayList<>();
            directories.add(file);
            while(!directories.isEmpty()){
                final List<Future<SubDirectoriesAndSize>> partialResults =
                        new ArrayList<>();
                for(final File directory:directories){
                    partialResults.add(
                            service.submit(new Callable<SubDirectoriesAndSize>() {
                                @Override
                                public SubDirectoriesAndSize call() throws Exception {
                                    return getDirsAndSize(directory);
                                }
                            })
                    );
                }
                directories.clear();
                for(final Future<SubDirectoriesAndSize> partialResultFuture:partialResults){
                    final SubDirectoriesAndSize subDirectoriesAndSize = partialResultFuture.get(100, TimeUnit.SECONDS);
                    directories.addAll(subDirectoriesAndSize.subDirectories);
                    total += subDirectoriesAndSize.size;
                }
            }
            return total;
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            TotalFileSizeConcurrentAnother totalFileSizeConcurrentAnother = new TotalFileSizeConcurrentAnother();
            File rootPath = new File("S:\\");
            long size = totalFileSizeConcurrentAnother.getTotalSizeOfFilesInDir(rootPath);
            System.out.println(size);
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
