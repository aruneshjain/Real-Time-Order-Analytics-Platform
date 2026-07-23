package com.arunesh.OrderService.dto.products;

import com.arunesh.OrderService.entity.Products;
import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private String category;
    private double price;

}
