package com.ze.sys.cache;

import com.ze.redis.init.AbstractCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCache extends AbstractCache {

    private static final String USER_CACHE_KEY = "USER";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        // 和数据库做联动，或者和其他数据来源做联动
        redisTemplate.opsForValue().set(USER_CACHE_KEY, "qj2");
    }

    @Override
    public <T> T getCache() {
        if (!redisTemplate.hasKey(USER_CACHE_KEY).booleanValue()) {
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(USER_CACHE_KEY);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(USER_CACHE_KEY);
    }
}
