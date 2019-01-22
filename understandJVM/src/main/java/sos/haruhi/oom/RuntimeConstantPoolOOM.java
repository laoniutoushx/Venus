package sos.haruhi.oom;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("科学").toString();
        System.out.println(str1.intern() == str1);

        /**
         * java 字符串 已经在 常量池 中初始化过，故 引用不相同
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
