package com.ze.sys.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCollection {

    @GetMapping("hello")
    private String hello(){
        return "hello";
    }
}
