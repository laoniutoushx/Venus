package com.haruhi.enumMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.enumMap</h3>
 * @Description <p>草本植物类型</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 16:32:24
 * @Version v1.0
 */
public class Herb {
                    // 一年生植物  多年生植物    两年生植物
    public enum Type { ANNUAL, FERENNIAL, BIENNIAL}

    final private String name;
    final public Type type;

    Herb(String name, Type type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    // 香草的数组，表示花园中的植物
    public static void main(String[] args) {
        Herb[] garden = new Herb[]{
                new Herb("h", Type.ANNUAL),
                new Herb("i", Type.FERENNIAL),
                new Herb("j", Type.BIENNIAL),
        };
        Set<Herb>[] herbsByType =
                new Set[Type.values().length];
        for(int i = 0; i < herbsByType.length; i++){
            herbsByType[i] = new HashSet<>();
        }
        for(Herb h:garden){
            herbsByType[h.type.ordinal()].add(h);
        }
        for(int i = 0; i < herbsByType.length; i++){
            System.out.printf("%s: %s%n",
                    Herb.Type.values()[i], herbsByType[i]);;
        }
    }
}
