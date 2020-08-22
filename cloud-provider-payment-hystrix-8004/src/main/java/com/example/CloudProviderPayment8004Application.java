package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangpeil
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class CloudProviderPayment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004Application.class,args);
    }
}
