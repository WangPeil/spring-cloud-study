package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author wangpeil
 */
@RestController
@Slf4j
public class PaymentController {

    private final DiscoveryClient discoveryClient;
    private static final String PAYMENT_SERVER_NAME = "CLOUD-PAYMENT-SERVICE";

    @Value("${server.port}")
    private String port;

    PaymentController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/payment/zookeeper")
    public String zookeeper() {
        return String.format("spring cloud port %s with zookeeper:%s ", port, UUID.randomUUID().toString());
    }

    @GetMapping("/payment/discovery")
    public DiscoveryClient discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名称: {}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_SERVER_NAME);
        for (ServiceInstance instance : instances) {
            log.info("服务名称: {}, uri: {}", instance.getServiceId(), instance.getUri());
        }
        return discoveryClient;
    }
}
