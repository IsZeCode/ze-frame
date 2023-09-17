package com.ze.sys.controller;


import com.ze.bean.Result;
import com.ze.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCollection {

    @GetMapping("hello")
    private String hello(){
        return "hello";
    }

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/testRedis")
    public Result testRedis() {
        redisUtil.set("me","则");
        return Result.ok();
    }
}
