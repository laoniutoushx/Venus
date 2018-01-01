package sos.haruhi.test;

/**
 * Description sos.haruhi.ws in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 */
public class TestClz {
    private static TestClz testClz;
    public TestClz(){
        System.out.println("d");
        testClz = new TestClz();
    }

    public static void main(String[] args) {
        TestClz j = new TestClz();
    }
}
