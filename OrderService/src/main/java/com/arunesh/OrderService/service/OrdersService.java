package com.arunesh.OrderService.service;

import com.arunesh.OrderService.entity.Orders;

import java.util.List;

public interface OrdersService {
    Orders createOrder(String productId, Double amount);

    List<Orders> getAllOrders();

    long countOrdersByProduct(String productId);
}
