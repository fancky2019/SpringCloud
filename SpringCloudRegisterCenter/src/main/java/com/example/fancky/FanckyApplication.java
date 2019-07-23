package com.example.fancky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//添加
@EnableEurekaServer
public class FanckyApplication {

    public static void main(String[] args) {
        //打开注册中心:http://localhost:8761

        /*
        先启动注册中心然后启动微服务客户端，否则微服务无法注册到注册中心。
         */
        SpringApplication.run(FanckyApplication.class, args);
    }

}

