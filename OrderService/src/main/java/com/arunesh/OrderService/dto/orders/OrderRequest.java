package com.arunesh.OrderService.dto.orders;

import lombok.Data;

@Data
public class OrderRequest {

    private String productId;
    private Double amount;

}
