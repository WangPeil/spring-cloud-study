package com.example.service;

import com.example.pojo.Payment;

/**
 * @author wangpeil
 */
public interface PaymentService {
    Payment select(Long id);

    Integer insert(Payment payment);
}
