package com.example.fancky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//添加
@EnableEurekaServer
public class FanckyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanckyApplication.class, args);
    }

}

