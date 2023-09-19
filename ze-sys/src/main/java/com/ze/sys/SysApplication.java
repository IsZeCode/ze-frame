package com.ze.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


/**
 * 顺带扫描别的模块的 @Bean  扫描 XX.mapper 以下的 mapper
 */
@MapperScan(value = "com.ze.*.mapper")
@SpringBootApplication
// 配置类扫描
@ComponentScan(value = "com.ze")
// 开启 注解缓存
@EnableCaching
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}
