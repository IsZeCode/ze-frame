package com.ze.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 顺带扫描别的模块的 @Bean  扫描 XX.mapper 以下的 mapper
 */
@MapperScan(value = "com.ze.*.mapper")
@SpringBootApplication
// 配置类扫描
@ComponentScan(value = "com.ze")
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}
