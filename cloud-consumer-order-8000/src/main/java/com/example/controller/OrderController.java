package com.example.controller;

import com.example.pojo.CommonResult;
import com.example.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangpeil
 */
@RestController
public class OrderController {
    private final RestTemplate restTemplate;
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<?> select(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @PostMapping("/payment/insert/{serial}")
    public CommonResult<?> insert(@PathVariable("serial") String serial) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert/"+serial, null, CommonResult.class);
    }

}
