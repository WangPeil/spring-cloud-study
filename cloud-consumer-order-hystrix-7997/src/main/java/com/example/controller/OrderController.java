package com.example.controller;

import com.example.pojo.CommonResult;
import com.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeil
 */
@RestController
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private static final int SUCCESS_CODE = 200;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult<?> paymentOk(@PathVariable("id") Long id) {
        return new CommonResult<>(SUCCESS_CODE, "success", orderService.paymentOk(id));
    }

    @PostMapping("/payment/hystrix/timeout/{id}")
    public CommonResult<?> paymentTimeout(@PathVariable("id") Long id) {
        return new CommonResult<>(SUCCESS_CODE, "success", orderService.paymentTimeout(id));
    }

}

