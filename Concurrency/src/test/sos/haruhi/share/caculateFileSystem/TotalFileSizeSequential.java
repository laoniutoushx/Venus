package sos.haruhi.share.caculateFileSystem;

import java.io.File;

/**
 * 单线程递归计算
 * 顺序递归计算文件系统大小
 */
public class TotalFileSizeSequential {
    long totalSize = 0;

    private void getTotalSizeOfFilesInDir(final File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files != null && files.length > 0) {
                for (File subFile : files) {
                    getTotalSizeOfFilesInDir(subFile);
                }
            }
        }else{
            totalSize += file.length();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String rootPath = "S:\\";
        TotalFileSizeSequential totalFileSizeSequential = new TotalFileSizeSequential();
        totalFileSizeSequential.getTotalSizeOfFilesInDir(new File(rootPath));
        System.out.println(totalFileSizeSequential.totalSize);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
