package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Description util in Venus
 * Created by SuzumiyaHaruhi on 2017/11/8.
 */
public class Collect {
    List<? super Apple> list;
    public static void main(String[] args) {
        Collect collect = new Collect();
        collect.list = new ArrayList<Apple>();
        collect.list.add(new Apple());
        // collect.list.add(new Fruit());       illegal
        collect.list.add(new Fushi());
        Apple apple = (Apple) collect.list.get(0);
        Fushi fushi = (Fushi) collect.list.get(1);
        System.out.println(apple);
        System.out.println(fushi);
    }
}
