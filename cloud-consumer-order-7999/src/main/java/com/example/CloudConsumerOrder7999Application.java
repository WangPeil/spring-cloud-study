package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangpeil
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder7999Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder7999Application.class, args);
    }
}
