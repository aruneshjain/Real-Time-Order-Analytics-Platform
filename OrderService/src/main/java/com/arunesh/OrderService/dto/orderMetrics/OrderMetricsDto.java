package com.arunesh.OrderService.dto.orderMetrics;

import com.arunesh.OrderService.entity.OrderMetrics;

public class OrderMetricsDto {

    public static OrderMetricsResponse toDTO(OrderMetrics orderMetrics) {

        OrderMetricsResponse response = new OrderMetricsResponse();

        response.setId(orderMetrics.getMetricId());
        response.setDate(orderMetrics.getMetricDate());
        response.setTotalOrders(orderMetrics.getTotalOrders());
        response.setTotalRevenue(orderMetrics.getTotalRevenue());
        response.setTopProduct(orderMetrics.getTopProduct());

        return response;
    }
}
