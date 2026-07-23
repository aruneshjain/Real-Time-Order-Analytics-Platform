package com.arunesh.OrderService.dto.products;

import lombok.Data;

@Data
public class ProductResponse {

    private String id;
    private String name;
    private String category;
    private double price;
}
