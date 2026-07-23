package com.arunesh.OrderService.dto.orders;

import com.arunesh.OrderService.dto.products.ProductResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class OrderResponse {

    @NotBlank(message = "Order ID cannot be blank")
    private String id;

    @Valid
    @NotNull(message = "Product cannot be null")
    private ProductResponse product;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Date cannot be null")
    private Instant date;
}
