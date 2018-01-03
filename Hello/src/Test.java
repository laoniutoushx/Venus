import java.math.BigDecimal;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/3 16:05:24
 * @Version v1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("2.55").multiply(new BigDecimal(100)).intValue());
        double re = 2.55 * 100;
        System.out.println(String.format("%010d", 3));
    }
}
