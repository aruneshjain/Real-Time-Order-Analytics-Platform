package com.arunesh.OrderService.service;

import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsResponse;

import java.util.List;

public interface OrderMetricsService {
    List<OrderMetricsResponse> getMetrics();
}
