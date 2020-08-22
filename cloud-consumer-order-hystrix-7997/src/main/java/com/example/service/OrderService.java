package com.example.service;

import com.example.pojo.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @GetMapping("/payment/hystrix/ok/{id}")
    CommonResult<?> paymentOk(@PathVariable("id") Long id);

    /**
     * 客户端服务熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @PostMapping("/payment/hystrix/timeout/{id}")
    CommonResult<?> paymentTimeout(@PathVariable("id") Long id);

    /**
     * 回调方法
     *
     * @param id
     * @return
     */
    default String paymentInfoTimeoutHandler(Long id) {
        return "对方请求繁忙，请重试。";
    }
}
