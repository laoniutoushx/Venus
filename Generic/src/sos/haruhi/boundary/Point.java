package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Description util in Venus
 * Created by SuzumiyaHaruhi on 2017/11/8.
 */
public class Point<T extends Number> {
    List<T> list;
    public static void main(String[] args) {
        List<? extends Number> lt = new ArrayList<Integer>();
        Point<Float> point = new Point<Float>();
        point.list = new ArrayList<Float>();

    }
}
