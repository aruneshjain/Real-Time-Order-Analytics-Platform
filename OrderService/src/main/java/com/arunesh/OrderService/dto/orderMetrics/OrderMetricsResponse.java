package com.arunesh.OrderService.dto.orderMetrics;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class OrderMetricsResponse {

    private Long id;
    private Date date;
    private Integer totalOrders;
    private Double totalRevenue;
    private String topProduct;
}
