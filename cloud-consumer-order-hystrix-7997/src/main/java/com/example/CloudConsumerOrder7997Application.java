package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangpeil
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CloudConsumerOrder7997Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder7997Application.class, args);
    }
}
