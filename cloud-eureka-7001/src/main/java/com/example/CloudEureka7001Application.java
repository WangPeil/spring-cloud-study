package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangpeil
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEureka7001Application.class, args);
    }
}
