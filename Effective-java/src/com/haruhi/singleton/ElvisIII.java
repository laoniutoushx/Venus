package com.haruhi.singleton;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.singleton</h3>
 * @Description <p>无偿提供了序列化机制，防止多次实例化</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 21:11:01
 * @Version v1.0
 */
public enum ElvisIII {
    INSTANCE;

    public String leaveTheBuilding(){
        return "haruhi";
    }

    public static void main(String[] args) {
        System.out.println(ElvisIII.INSTANCE.leaveTheBuilding());
    }
}
