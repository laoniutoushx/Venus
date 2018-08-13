package sos.haruhi.caculateFileSystem;

import org.apache.commons.lang3.time.DateUtils;

import java.io.File;

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
        String rootPath = "E:\\";
        TotalFileSizeSequential totalFileSizeSequential = new TotalFileSizeSequential();
        totalFileSizeSequential.getTotalSizeOfFilesInDir(new File(rootPath));
        System.out.println(totalFileSizeSequential.totalSize);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
