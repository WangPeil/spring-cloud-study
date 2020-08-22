package com.example.controller;

import com.example.pojo.CommonResult;
import com.example.pojo.Payment;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeil
 */
@RestController
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${service.port}")
    private  String port;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult<?> paymentOk(@PathVariable("id") Long id) {
        return new CommonResult<>(200,"success",paymentService.paymentInfo(id));
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult<?> paymentTimeout(@PathVariable("id") Long id) {
        return new CommonResult<>(200,"success",paymentService.paymentInfoTimeout(id));
    }
}
