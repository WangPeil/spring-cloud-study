package com.example.controller;


import com.example.pojo.CommonResult;
import com.example.pojo.Payment;
import com.example.service.PaymentService;
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
public class PaymentController {

    private final PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id) {
        Payment payment = paymentService.select(id);
        if (payment != null) {
            log.info("查询数据成功");
            return new CommonResult<>(200, "success", payment);
        } else {
            log.warn("查询数据失败");
            return new CommonResult<>(400, "fail");
        }

    }

    @PostMapping("/payment/insert/{serial}")
    public CommonResult<Integer> insert(@PathVariable("serial") String serial) {
        Integer result = paymentService.insert(new Payment(serial));
        if (result > 0) {
            log.info("插入数据成功");
            return new CommonResult<>(200, "success", result);
        } else {
            log.warn("插入数据失败");
            return new CommonResult<>(400, "fail");
        }

    }
}
