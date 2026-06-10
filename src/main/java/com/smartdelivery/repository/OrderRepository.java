package com.smartdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartdelivery.model.Order;
import com.smartdelivery.model.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

    long countByStatus(OrderStatus status);
}