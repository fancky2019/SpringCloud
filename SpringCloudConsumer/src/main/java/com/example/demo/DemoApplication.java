package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DemoApplication {
    /*
    此项目多余，暂时不删除
     */
    public static void main(String[] args) {
        /*
        FeignClient:集成了Ribbon和Hystrix
        用于微服务之间的调用
         */
        SpringApplication.run(DemoApplication.class, args);
    }

}

