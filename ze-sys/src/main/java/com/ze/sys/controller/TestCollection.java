package com.ze.sys.controller;


import com.ze.bean.Result;
import com.ze.redis.util.RedisShareLockUtil;
import com.ze.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestCollection {

    @GetMapping("hello")
    private String hello() {
        return "hello";
    }

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/testRedis")
    public Result testRedis() {
        redisUtil.set("me", "则");
        return Result.ok();
    }

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @GetMapping("/testRedisShareLock")
    public String testRedisShareLock() {
        boolean result = redisShareLockUtil.lock("qj", "123456", 10000L);
        System.out.println("分布式锁获取：" + result);
        return String.valueOf(result);
    }

    @GetMapping("/testLog")
    public Result testLog() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            log.info("这是{}条日志！", i);
        }
        long endTime = System.currentTimeMillis();
        log.info("当前耗时：{}", endTime - startTime);
        return Result.ok();
    }
}
