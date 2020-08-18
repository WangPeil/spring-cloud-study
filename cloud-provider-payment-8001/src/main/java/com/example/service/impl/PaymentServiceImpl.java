package com.example.service.impl;

import com.example.dao.PaymentDao;
import com.example.pojo.Payment;
import com.example.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author wangpeil
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment select(Long id) {
        Objects.requireNonNull(id);
        return paymentDao.select(id);
    }

    @Override
    public Integer insert(Payment payment) {
        Objects.requireNonNull(payment);
        return paymentDao.insert(payment);
    }
}
