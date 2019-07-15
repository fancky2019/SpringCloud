package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class DemoApplication {

    //注意创建模板选择Cloud Discovery下的Eureka Server,不选择模板加入Gateway依赖 Maven Unknown错误.
    //添加好Gateway依赖，刷新Maven,Gateway依赖显示出来之后，将pom文件中的Eureka依赖删掉，
    //刷新Maven发信Eureka依赖移除了。
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    /**
     * 此方法可有可无，没有就用配置文件
     */
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
        config.setParts(1);
        return builder.routes()
                .route("hao123", r -> r.path("/hao/**").filters(f -> f.stripPrefix(1)).uri("https://www.hao123.com/"))
//                .route("host_route", r -> r.path("/b/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8082"))
                .build();
    }
}

