package com.example.service;

import com.example.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangpeil
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {
    @GetMapping("/payment/{id}")
    CommonResult<?> select(@PathVariable("id") Long id);

    @PostMapping("/payment/insert/{serial}")
    CommonResult<?> insert(@PathVariable("serial") String serial);
}
