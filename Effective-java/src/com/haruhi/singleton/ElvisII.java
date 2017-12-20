package com.haruhi.singleton;

import java.io.Serializable;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.singleton</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 21:01:49
 * @Version v1.0
 */
public class ElvisII implements Serializable {
    transient final private static ElvisII INSTANCE = new ElvisII();
    private ElvisII(){}
    public static ElvisII getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuilding(){

    }
}
