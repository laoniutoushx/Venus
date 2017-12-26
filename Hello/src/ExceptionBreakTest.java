/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p>异常终端检测</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/23 13:05:47
 * @Version v1.0
 */
public class ExceptionBreakTest {
    public static void main(String[] args) {
        ExceptionBreakTest test = new ExceptionBreakTest();
        try {
            test.hh("haru");
            test.tt();
            System.out.println("hhh");

            System.out.println("234234");
        } catch(Exception e){
            System.out.println("异常");
        }
    }

    public <T> T hh(T t) throws Exception{
        System.out.println("gg");
        if(t == null)
            throw new Exception();
        else
            return t;
    }

    public void tt() throws Exception{
        System.out.println("tt");
        throw new Exception();
    }
}

