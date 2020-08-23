package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
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
     *
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

    //========服务熔断========

    /**
     * 如果在10秒内，失败率达到请求次数（10）的百分之60，也就是6次就会打开断路器；否则断路器依然关闭
     * HystrixCommandProperties存放对应配置参数
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 开启服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //设置请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //设置时间窗口
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败失败率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("ID不能为负数");
        }
        return "正常访问: 序列号:" + UUID.randomUUID().toString();
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "开始断路器, 无法正常访问";
    }

}
