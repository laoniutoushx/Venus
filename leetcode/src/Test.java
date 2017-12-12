import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
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
