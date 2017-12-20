package com.haruhi.enumMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.enumMap</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 19:57:01
 * @Version v1.0
 */
public class EnumMap {
    public static void main(String[] args) {
        Herb[] garden = new Herb[]{
                new Herb("h", Herb.Type.ANNUAL),
                new Herb("i", Herb.Type.FERENNIAL),
                new Herb("j", Herb.Type.BIENNIAL),
        };

        Map<Herb.Type, Set<Herb>> herbsByType =
                new java.util.EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
        for(Herb.Type t:Herb.Type.values()){
            herbsByType.put(t, new HashSet<Herb>());
        }

        for(Herb g:garden){
            herbsByType.get(g.type).add(g);
        }

        System.out.println(herbsByType);
    }
}
