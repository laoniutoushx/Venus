package com.haruhi.singleton;

import java.io.Serializable;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.singleton</h3>
 * @Description <p>简单的单例模式</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 20:59:54
 * @Version v1.0
 */
public class Elvis implements Serializable {
    final public static Elvis INSTANCE = new Elvis();
    private Elvis(){}

    public void leaveTheBuilding(){

    }
}
