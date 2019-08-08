package com.fancky.microserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicebApplication.class, args);
    }

}
