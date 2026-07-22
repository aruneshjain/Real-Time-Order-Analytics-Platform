package com.arunesh.OrderService.repository;

import com.arunesh.OrderService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, String> {
    long countByProductId(String productId);
}
