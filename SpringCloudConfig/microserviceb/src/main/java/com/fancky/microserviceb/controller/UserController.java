package com.fancky.microserviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController

@RequestMapping("/user")
public class UserController {
    //获取配置文件的值
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${microservicea.interval}")
    private String interval;
    @Value("${microservicea.account}")
    private String account;

    //http://localhost:8032/user/getUsername
    @GetMapping("/getUsername")
    public String getUsername() {
        return username;
    }

    @GetMapping("/getMicroserviceaConfig")
    public String getMicroserviceaConfig() {
        return MessageFormat.format("{0},{1}", account, interval);
    }
}
