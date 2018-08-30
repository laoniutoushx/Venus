package sos.nagato.pojo;

import java.util.List;

/**
 * @describe
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 系统管理员
 * @version 1.0
 * @date 2016年12月20日 上午10:38:36
 * Copyright(c) XZHI All Rights Reserved.
 */
public class Page {


    private int from;
    private int size;
    private long allCount;
    private List<?> datas;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getAllCount() {
        return allCount;
    }

    public void setAllCount(long allCount) {
        this.allCount = allCount;
    }

    public List<?> getDatas() {
        return datas;
    }

    public void setDatas(List<?> datas) {
        this.datas = datas;
    }

}

