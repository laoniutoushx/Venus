package sos.haruhi.share.caculateFileSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName MyFileSizeCaculator
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/22 21:16
 * @Version 10032
 **/
public class MyFileSizeCaculator {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        File file = new File("S:\\");
        long totalSize = new MyFileSizeCaculator().getTotalFileSize(file);
        System.out.println(totalSize);
    }

    private long getTotalFileSize(File file) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service = null;
        long totalSize = 0;
        try {
            List<File> directories = new ArrayList<>();
            service = Executors.newFixedThreadPool(20);

            directories.add(file);
            while (!directories.isEmpty()) {
                List<Future<SubDirsAndFileSize>> curDirsAndSizes = new ArrayList<>();
                for (final File curFile : directories) {
                    curDirsAndSizes.add(service.submit(new Callable<SubDirsAndFileSize>() {
                        @Override
                        public SubDirsAndFileSize call() throws Exception {
                            return caculatorFileSize(curFile);
                        }
                    }));
                }
                directories.clear();
                for (final Future<SubDirsAndFileSize> curDirAndSize : curDirsAndSizes) {
                    SubDirsAndFileSize dirsAndFileSize = curDirAndSize.get(100, TimeUnit.SECONDS);
                    directories.addAll(dirsAndFileSize.getSubLevelDirs());
                    totalSize += dirsAndFileSize.getCurDirLevelFileSize();
                }
            }
        } finally {
            service.shutdown();
        }
        return totalSize;
    }

    private SubDirsAndFileSize caculatorFileSize(File curFile) {
        long curDirLevelFileSize = 0;
        List<File> subLevelDirs = new ArrayList<>();
        if (curFile != null) {
            File[] files = curFile.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        curDirLevelFileSize += f.length();
                    } else {
                        subLevelDirs.add(f);
                    }
                }
            }
        }
        return new SubDirsAndFileSize(curDirLevelFileSize, subLevelDirs);
    }

    private class SubDirsAndFileSize {
        private long curDirLevelFileSize;
        private List<File> subLevelDirs;

        public SubDirsAndFileSize(long curDirLevelFileSize, List<File> subLevelDirs) {
            this.curDirLevelFileSize = curDirLevelFileSize;
            this.subLevelDirs = subLevelDirs;
        }

        public long getCurDirLevelFileSize() {
            return curDirLevelFileSize;
        }

        public List<File> getSubLevelDirs() {
            return subLevelDirs;
        }
    }
}
