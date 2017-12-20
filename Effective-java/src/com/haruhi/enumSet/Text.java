package com.haruhi.enumSet;

import java.util.Set;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.enumSet</h3>
 * @Description <p>枚举 位域</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 16:17:31
 * @Version v1.0
 */
public class Text {
    final public static int STYLE_BOLD = 1 << 0;
    final public static int STYLE_ITALIC = 1 << 1;
    final public static int STYLE_UNDERLINE = 1 << 2;
    final public static int STYLE_STRIKETHROUGH = 1 << 3;
    public void applyStyles(int styles){
        System.out.println(styles);
    }

    public static void main(String[] args) {
        new Text().applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }

    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void applyStyle(Set<Style> styles){

    }
}
