package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
注册到注册中心的微服务。
网关会根据服务名称（该服务名称：server）自动路由到该服务中的路径。
具体信息参见网关工程。
 */
@SpringBootApplication
@EnableEurekaClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

