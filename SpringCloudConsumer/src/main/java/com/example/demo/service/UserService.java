package com.example.demo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//指定服务名称：Instances currently registered with Eureka列表里的服务
/*
OpenFeign:服务之间的调用，集成了Ribbon和Hystrix。
 */
@FeignClient("server")
@Service
public interface UserService {
    @RequestMapping(value = "/user")
    String home(@RequestParam String name);
}
