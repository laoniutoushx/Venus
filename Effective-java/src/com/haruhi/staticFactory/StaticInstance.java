package com.haruhi.staticFactory;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.staticFactory</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 13:19:39
 * @Version v1.0
 */
public class StaticInstance {
    public static void main(String[] args) {
        valueOf(true);
    }
    /**
     * <p>valueOf</p>
     * @Description
     * @Param b
     * @Author SuzumiyaHaruhi
     * @Time 2017/12/16 13:23
     * @Return java.lang.Boolean
     */
    public static Boolean valueOf(boolean b){
        assert b : "haruhi";
        System.out.println(b);
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
