package com.haruhi.builder;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.builder</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 15:19:15
 * @Version v1.0
 */
public interface IBuilder<T> {
    /**
     * <p>build</p>
     * @Description 构造器
     * @Author SuzumiyaHaruhi
     * @Time 2017/12/16 15:20
     * @Return T
     */
    T build();
}
