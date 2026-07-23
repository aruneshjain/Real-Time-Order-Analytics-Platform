package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.entity.OrderMetrics;
import com.arunesh.OrderService.service.OrderMetricsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@AllArgsConstructor
public class OrderMetricsController {
    private final OrderMetricsService service;

    @GetMapping
    public List<OrderMetrics> getMetrics() { return service.getMetrics(); }
}
