package com.example.springclouddemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${spring.application.name}")
    String servername;
    @Value("${server.port}")
    Integer port;

    @RequestMapping("")
    public String home(@RequestParam String name) {
        return "servername:" + servername + ",port:" + port.toString() + ",param:" + name;


    }
}
