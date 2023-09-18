package com.ze.sys.cache;

import com.ze.redis.init.AbstractCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SysUserCache extends AbstractCache {

    private static final String SYS_USER_CACHE_KEY = "SYS_USER";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        // 和数据库做联动，或者和其他数据来源做联动
        redisTemplate.opsForValue().set(SYS_USER_CACHE_KEY, "qj1");
    }

    @Override
    public <T> T getCache() {
        if (!redisTemplate.hasKey(SYS_USER_CACHE_KEY).booleanValue()) {
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(SYS_USER_CACHE_KEY);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(SYS_USER_CACHE_KEY);
    }
}
