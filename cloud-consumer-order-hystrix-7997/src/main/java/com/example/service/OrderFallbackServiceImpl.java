package com.example.service;

import com.example.pojo.CommonResult;
import org.springframework.stereotype.Service;

/**
 * 服务降级方法实现类 解决业务代码和回调方法耦合问题
 * @author wangpeil
 */
@Service
public class OrderFallbackServiceImpl implements OrderService{
    private static final Integer FAIL_CODE = 400;
    @Override
    public CommonResult<?> paymentOk(Long id) {
        return new CommonResult<>(FAIL_CODE,"fail","对方请求繁忙，请重试。");
    }

    @Override
    public CommonResult<?> paymentTimeout(Long id) {
        return new CommonResult<>(FAIL_CODE,"fail","对方请求繁忙，请重试。");
    }
}
