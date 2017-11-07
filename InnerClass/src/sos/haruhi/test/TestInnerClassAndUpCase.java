package sos.haruhi.test;

import sos.haruhi.clz.Contents;
import sos.haruhi.clz.Destination;
import sos.haruhi.clz.InnerClzAndUpCase;

/**
 * Description sos.haruhi.test in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 */
public class TestInnerClassAndUpCase {
    public static void main(String[] args) {
        InnerClzAndUpCase innerClzAndUpCase = new InnerClzAndUpCase();
        Contents contents = innerClzAndUpCase.getContents();
        Destination destination = innerClzAndUpCase.getDestination("tibet");
        // 非法
        // InnerClzAndUpCase.IContents contents = innerClzAndUpCase.new IContents();
    }
}
