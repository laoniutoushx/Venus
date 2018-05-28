package sos.haruhi.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;






/**
 * @author bpan
 *
 * created 2018年2月27日
 */
public class CreateExcelFile {

    private static HSSFWorkbook hWorkbook = null;
    private static XSSFWorkbook xWorkbook = null;

    /**
     * 判断文件是否存在.
     * @param fileDir  文件路径
     * @return
     */
    public static boolean fileExist(String fileDir){
        boolean flag = false;
        File file = new File(fileDir);
        flag = file.exists();
        return flag;
    }

    /**
     * 判断文件的sheet是否存在.
     * @param fileDir   文件路径
     * @param sheetName  表格索引名
     * @return boolean
     */
    public static boolean XlsSheetExist(String fileDir, String sheetName){

        boolean flag = false;
        File file = new File(fileDir);

        if (file.exists()) {
            //文件存在，创建workbook
            try {
                hWorkbook = new HSSFWorkbook(new FileInputStream(file));

                HSSFSheet sheet = hWorkbook.getSheet(sheetName);
                if (sheet!=null) {
                    //文件存在，sheet存在

                    flag = true;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            //文件不存在
            flag = false;
        }
        return flag;
    }

    /**
     * 创建新excel(xls).
     * @param fileDir excel的路径
//     * @param sheetNames 要创建的表格索引列表
//     * @param titleRow  excel的第一行即表格头
     */
    public static void createExcelXls(String fileDir){

        //创建workbook
        hWorkbook = new HSSFWorkbook();
        //新建文件
        FileOutputStream fileOutputStream = null;
//        HSSFRow row = null;
        try {

            //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
//            for(int i = 0; i<sheetNames.size(); i++){
//                hWorkbook.createSheet("1");
                fileOutputStream = new FileOutputStream(fileDir);
                hWorkbook.write(fileOutputStream);
//            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件.
     * @param fileDir  文件路径
     * @return 如果文件不存在返回false, 如果文件存在删除成功之后返回true
     */
    public static boolean deleteExcel(String fileDir) {
        boolean flag = false;
        File file = new File(fileDir);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                file.delete();
                flag = true;
            }
        }
        return flag;
    }

}
