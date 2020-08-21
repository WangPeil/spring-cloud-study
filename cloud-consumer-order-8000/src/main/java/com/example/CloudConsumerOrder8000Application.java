package com.example;

import com.rule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wangpeil
 * name指那个微服务
 * 替换默认的Ribbon的负载均衡算法
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CustomRule.class)
public class CloudConsumerOrder8000Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder8000Application.class, args);
    }
}
