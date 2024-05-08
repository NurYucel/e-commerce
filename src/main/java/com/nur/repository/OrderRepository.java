package com.nur.repository;

import com.nur.entities.Order;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderCode(String orderCode);
    List<Order> findByCustomerId(Long customerId);
}
