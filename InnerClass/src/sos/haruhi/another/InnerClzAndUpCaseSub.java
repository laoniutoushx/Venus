package sos.haruhi.another;

import sos.haruhi.clz.Contents;
import sos.haruhi.clz.Destination;
import sos.haruhi.clz.InnerClzAndUpCase;

/**
 * Description sos.haruhi.another in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 */
public class InnerClzAndUpCaseSub extends InnerClzAndUpCase {

    public Destination destination(String s){
        return super.getDestination(s);
    }

    public static void main(String[] args) {
        System.out.println(2<<3);
    }
}
