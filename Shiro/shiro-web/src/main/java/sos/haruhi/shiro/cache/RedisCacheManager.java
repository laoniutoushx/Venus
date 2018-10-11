package sos.haruhi.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @ClassName RedisCacheManager
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/11 21:18
 * @Version 10032
 **/
public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
