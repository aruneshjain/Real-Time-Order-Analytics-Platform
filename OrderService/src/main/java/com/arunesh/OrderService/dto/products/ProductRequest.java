package com.arunesh.OrderService.dto.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @Positive(message = "Price must be a positive number")
    private double price;

}
