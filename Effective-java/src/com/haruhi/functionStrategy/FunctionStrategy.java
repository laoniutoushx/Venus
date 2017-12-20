package com.haruhi.functionStrategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.functionStrategy</h3>
 * @Description <p> 函数对象 表示策略 </p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 22:45:02
 * @Version v1.0
 */
public class FunctionStrategy {
    final public static StrLenCompare INSTANCE = new StrLenCompare();
    private static class StrLenCompare implements Compare<String>{
        @Override
        public int compare(java.lang.String o1, java.lang.String o2) {
            return o1.length() - o2.length();
        }
    }
    public static void main(String[] args) {
        String str[] = new String[]{"333", "3", "lksdfj", "jk"};
        Arrays.sort(str, INSTANCE);
        for(String item:str){
            System.out.println(item);
        }
    }
}
