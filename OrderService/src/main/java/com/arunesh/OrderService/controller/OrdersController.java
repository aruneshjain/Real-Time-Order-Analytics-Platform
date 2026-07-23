package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.orders.OrderRequest;
import com.arunesh.OrderService.dto.orders.OrderResponse;
import com.arunesh.OrderService.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService service;

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> getOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/count/{productId}")
    public long countOrders(@PathVariable String productId) {
        return service.countOrdersByProduct(productId);
    }
}
