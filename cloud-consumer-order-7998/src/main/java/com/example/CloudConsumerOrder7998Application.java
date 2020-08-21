package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangpeil
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOrder7998Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder7998Application.class, args);
    }
}
