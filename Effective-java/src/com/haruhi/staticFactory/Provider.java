package com.haruhi.staticFactory;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.staticFactory</h3>
 * @Description <p>提供者</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 13:28:43
 * @Version v1.0
 */
public interface Provider {
    Service newService();
}
