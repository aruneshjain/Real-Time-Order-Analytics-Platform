package com.arunesh.OrderService.dto.orderMetrics;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;

@Data
public class OrderMetricsResponse {

    @NotNull(message = "Metric ID cannot be null")
    private Long id;

    @NotNull(message = "Date cannot be null")
    private Date date;

    @NotNull(message = "Total orders cannot be null")
    @PositiveOrZero(message = "Total orders must be zero or positive")
    private Integer totalOrders;

    @NotNull(message = "Total revenue cannot be null")
    @PositiveOrZero(message = "Total revenue must be zero or positive")
    private Double totalRevenue;

    private String topProduct;
}
