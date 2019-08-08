package com.fancky.microservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceaApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceaApplication.class, args);
    }

}
