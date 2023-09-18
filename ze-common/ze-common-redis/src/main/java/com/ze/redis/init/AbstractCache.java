package com.ze.redis.init;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCache {

    public abstract void initCache();

    public abstract <T> T getCache();

    public abstract void clearCache();

    public void reloadCache() {
        clearCache();
        initCache();
    }
}