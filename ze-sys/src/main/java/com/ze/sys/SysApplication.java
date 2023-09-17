package com.ze.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 顺带扫描别的模块的 @Bean
 */
@ComponentScan(value = "com.ze")
@MapperScan(value = "com.ze.*.mapper")
@SpringBootApplication
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}
