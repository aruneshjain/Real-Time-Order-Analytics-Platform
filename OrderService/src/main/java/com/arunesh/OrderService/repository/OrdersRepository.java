package com.arunesh.OrderService.repository;

import com.arunesh.OrderService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    long countByProduct_ProductId(String productId);
}
