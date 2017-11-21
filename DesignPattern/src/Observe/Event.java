package Observe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description Observe in Venus
 * Created by SuzumiyaHaruhi on 2017/11/12.
 */
public abstract class Event {
    public static void main(String[] args) {
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyyMMdd HHmmss").parse("20171111 110000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d1 = null;
        try {
            d1 = new SimpleDateFormat("yyyyMMdd HHmmss").parse("20171111 113000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d1.getTime()-d.getTime());
    }
}
