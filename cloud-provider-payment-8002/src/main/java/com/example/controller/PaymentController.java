package com.example.controller;


import com.example.pojo.CommonResult;
import com.example.pojo.Payment;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpeil
 */
@RestController
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;
    private final DiscoveryClient discoveryClient;
    private static final String PAYMENT_SERVER_NAME = "CLOUD-PAYMENT-SERVICE";

    @Value("${server.port}")
    private String port;

    PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id) {
        Payment payment = paymentService.select(id);
        if (payment != null) {
            log.info("查询数据成功, 服务端口号{}", port);
            return new CommonResult<>(200, "success", payment);
        } else {
            log.warn("查询数据失败, 服务端口号{}", port);
            return new CommonResult<>(400, "fail");
        }
    }

    @PostMapping("/payment/insert/{serial}")
    public CommonResult<Integer> insert(@PathVariable("serial") String serial) {
        Integer result = paymentService.insert(new Payment(serial));
        if (result > 0) {
            log.info("插入数据成功, 服务端口号{}", port);
            return new CommonResult<>(200, "success", result);
        } else {
            log.warn("插入数据失败, 服务端口号{}", port);
            return new CommonResult<>(400, "fail");
        }
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
