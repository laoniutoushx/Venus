import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/3 16:05:24
 * @Version v1.0
 */
public class Test {
    public static void main(String[] args) throws ParseException {
//        System.out.println(new BigDecimal("2.55").multiply(new BigDecimal(100)).intValue());
//        double re = 2.55 * 100;
//        System.out.println(String.format("%010d", 3));
        Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse("20180124000850");
        date.setSeconds(0);
        date.setMinutes(date.getMinutes() - date.getMinutes() % 10);
        Timestamp tmie = Timestamp.valueOf("2018-01-24 00:08:50");
        System.out.println(tmie.toString());
    }
}
