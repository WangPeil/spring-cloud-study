package com.example.dao;

import com.example.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wangpeil
 */
@Repository
@Mapper
public interface PaymentDao {
    Integer insert(Payment payment);

    Payment select(@Param("id") Long id);
}
