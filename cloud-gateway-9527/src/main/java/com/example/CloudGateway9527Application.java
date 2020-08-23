package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * gateway服务网关 配置路由 断言 过滤器
 * @author wangpeil
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateway9527Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway9527Application.class, args);
    }
}
