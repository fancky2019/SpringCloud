package com.example.demo.controller;

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

    /*
        #会用自带的负载均衡：http://localhost:8080/gateway1/user?name=a
        # 客户端负载均衡实现：两个微服务注册到注册中心的名称一样，ip和端口不一样
   */
    @RequestMapping("")
    public String home(@RequestParam String name) {
        return "servername:" + servername + ",port:" + port.toString() + ",param:" + name;
    }

    @RequestMapping("/timeOut")
    public String timeOut(@RequestParam String name) {
        //  Integer m=Integer.valueOf("m");
        try {
            //超时异常
            //hystrix： #断路器超时时间，默认1000ms
            Thread.sleep(1500);
        } catch (Exception ex) {

        }
        return "servername:" + servername + ",port:" + port.toString() + ",param:" + name;
    }
}
