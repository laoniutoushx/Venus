package com.haruhi.staticFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.staticFactory</h3>
 * @Description <p>服务实现 服务注册 服务接入</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 13:30:18
 * @Version v1.0
 */
public class Services {
    private Services() {}   // prevent instantiation 阻止实例化
    // Maps service names to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // provider registation API  提供者注册 API
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }
    public static void registerProvider(String name, Provider p){
        providers.put(name, p);
    }

    // Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if(p == null){
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
