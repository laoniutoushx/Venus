import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/9 15:24:50
 * @Version v1.0
 */
public class HttpUtilsTest {

    @Test
    public void testGet(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("TERMINALNO", "YTJ00002");
        String result = new HttpUtils().sendGet("http://124.152.203.74:443/SWSMK/wt_terminalMsgQuery.htm", map);
        assertNotNull(result);

        System.out.println(result);
    }
}