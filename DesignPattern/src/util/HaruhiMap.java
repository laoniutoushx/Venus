package util;

import Observe.Listener;
import com.sun.javafx.collections.MapListenerHelper;
import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description util in Venus
 * Created by SuzumiyaHaruhi on 2017/10/18.
 */
public class HaruhiMap<K, V> {
    private int size = 8;
    Object[] store = new Object[size];



    public void put(K key, V obj){

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public native int hashCode();

    public static void main(String[] args) {
        int[] numbers = {5, 5, 3, 2, 2, 1256, 3};
        int result = 0;
        for(int i = 0; i < numbers.length; i++){
            result ^= numbers[i];
        }
        System.out.println(result);
        String haruhi = "hxxxxxrrhii";
        char charatcer = 0;
        char another = 'H';
        System.out.println(charatcer ^ another);
        for(int i = 0; i < haruhi.length(); i++){
            charatcer ^= haruhi.charAt(i);
        }
        System.out.println(charatcer);
        System.out.println(haruhi.hashCode());
        System.out.println(haruhi.hashCode() >>> 16);


        int a = 14, b = 10;
        System.out.println((a + b) / 2);
        System.out.println((a & b) + ((a ^ b) >> 1));
        a ^= b;
        a ^= b;
        a ^= b;
        System.out.println(a + " : " + b);

        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());

    }

    public <T>T say(T t){
        System.out.println(t);
        return t;
    }



}
