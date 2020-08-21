package com.example.controller;

import com.example.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wangpeil
 */
@RestController
@Slf4j
public class OrderController {
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;
    private static final String PAYMENT_SERVER_NAME = "CLOUD-PAYMENT-CONSUMER";
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<?> select(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @PostMapping("/payment/insert/{serial}")
    public CommonResult<?> insert(@PathVariable("serial") String serial) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert/" + serial, null, CommonResult.class);
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
