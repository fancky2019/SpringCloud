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

    /*
    springboot和springcloud版本要匹配，不然maven依赖就会报错。有重复，不同版本依赖要在pop引用位置排除不同版本
    如：
    <!--        排除slf4j-log4j12多个版本依赖-->
        <!-- https://mvnrepository.com/artifact/org.apache.curator/curator-recipes -->
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>
            <version>5.1.0</version>
        </dependency>






    <!--    springboot和springcloud版本匹配： https://start.spring.io/actuator/info-->

   <!--    其他-->
   <!--    spring-cloud-dependencies 版本列表可查看：https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-dependencies-->
   <!--    spring-boot-starter-parent 版本列表可查看：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent-->


     */


    /*
    启动的时候先启动注册中心，其他微服务要注册到注册中心，网关从注册中心访问微服务。
     */


    //注意创建模板选择Cloud Discovery下的Eureka Server,不选择模板加入Gateway依赖 Maven Unknown错误.
    //添加好Gateway依赖，刷新Maven,Gateway依赖显示出来之后，将pom文件中的Eureka依赖删掉，
    //刷新Maven发信Eureka依赖移除了。


    /*
    Spring Cloud Gateway 功能：
    一、路由转发、负载均衡。
    二、过滤。Filter过滤
    三、限流。集成Redis 实现。
    四、熔断。集成Hystrix来实现。
    五、鉴权。Filter通过JWT。


    负载均衡（客户端负载均衡）：默认的负载均衡规则在RibbonClientConfiguration类中配置，
             和Feign一样Gateway集成了Ribbon和hystrix。

    客户端负载均衡：客户端负载均衡：例如spring cloud中的ribbon，客户端会有一个服务器地址列表，在发送请求前通过负载均衡算法选择一个服务器，然后进行访问，这是客户端负载均衡；
                    即在客户端就进行负载均衡算法分配。
    服务端负载均衡：如Nginx，通过Ngnix进行负载均衡，先发送请求，然后通过负载均衡算法，在多个服务器之间选择一个进行访问；
                    即在服务器端再进行负载均衡算法分配。


/*
#指定本服务的端口号
server:
  port: 8762
spring:
  application:
    # name到服务中心会转换成大写
    name: server
     */
    /*
    注册中心：服务注册到注册中心，服务指定自己的名称，到服务中心会转换成大写。
              多个服务可注册相同的名称，网关路由转发url采用lb:前缀就会负载均衡。

    网关执行流程：一、访问网关url。
                  二、网关路由url转发。url前缀lb:代表LoadBalance
                  三、到注册中心去找网关转发的url并访问。

     */
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

