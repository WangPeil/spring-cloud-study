package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangpeil
 */
@Service
@Slf4j
public class PaymentService {
    public String paymentInfo(Long id) {
        return "OK, Thread: " + Thread.currentThread().getName() + " id:" + id;
    }

    /**
     * 使用HystrixCommand设置回调方法 当前服务不可用，采用服务降级
     * 超时服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String paymentInfoTimeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("sleep被强制中断", e);
        }
        return "Timeout, Thread: " + Thread.currentThread().getName() + " id:" + id;
    }

    public String paymentInfoTimeoutHandler(Long id) {
        return "请重试。";
    }
}
