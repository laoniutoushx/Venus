import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        File file = new File("S:\\图片");
        File test = null;
        for(String item:file.list()){
            test = new File("S:\\图片\\"+item);
            if(test.isFile()){

            }
            if(test.isDirectory()){

            }
            System.out.println(item);
        }
        long ddd = 2l;
        double b = 2.0d;
        float s = 2.22f;
        int a[] = {1, 2, 3, 4, 5};
        int[] t = {3, 4,5};
        String[] str = {"33", "ff"};
        String sss[] = {"f", "f"};

        String result = "name=haruhi&age=12&index=33&class=sanyi&istrue=t";
        System.out.println(parseResult(result));
        BigDecimal d = new BigDecimal("333.33333");
        System.out.println(d.intValue());
    }

    /**
     * 获取下一天的日期
     * @return
     */
    public static Date getNextDay(){
        try {
            Thread.currentThread().sleep(24 * 60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Date();
    }


    public static Map<String, String> parseResult(String result){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isNotBlank(result)){
            String[] keyValue = result.split("&");
            for(String item:keyValue){
                String[] it = item.split("=");
                if(StringUtils.isNotBlank(it[0]) && StringUtils.isNotBlank(it[1])){
                    map.put(it[0], it[1]);
                }else{
                    map.put(it[0], "");
                }
            }
        }
        return map;
    }
}
