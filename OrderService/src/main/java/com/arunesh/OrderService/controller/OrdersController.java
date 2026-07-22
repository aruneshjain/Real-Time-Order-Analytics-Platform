package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.entity.Orders;
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
    public Orders createOrder(@RequestParam String productId, @RequestParam Double amount) {
        return service.createOrder(productId, amount);
    }

    @GetMapping
    public List<Orders> getOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/count/{productId}")
    public long countOrders(@PathVariable String productId) {
        return service.countOrdersByProduct(productId);
    }
}
