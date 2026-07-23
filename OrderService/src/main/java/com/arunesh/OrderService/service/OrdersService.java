package com.arunesh.OrderService.service;

import com.arunesh.OrderService.dto.orders.OrderRequest;
import com.arunesh.OrderService.dto.orders.OrderResponse;

import java.util.List;

public interface OrdersService {
    OrderResponse createOrder(OrderRequest request);

    List<OrderResponse> getAllOrders();

    long countOrdersByProduct(String productId);
}
