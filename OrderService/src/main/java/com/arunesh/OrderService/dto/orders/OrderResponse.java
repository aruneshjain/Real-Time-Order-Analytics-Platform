package com.arunesh.OrderService.dto.orders;

import com.arunesh.OrderService.dto.products.ProductResponse;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class OrderResponse {

    private String id;
    private ProductResponse product;
    private Double amount;
    private Instant date;
}
