package com.arunesh.OrderService.dto.products;

import com.arunesh.OrderService.entity.Products;

public class ProductDto {

    public static Products toEntity(ProductRequest productRequest) {
        Products product = new Products();
        product.setProductName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        return product;
    }

    public static ProductResponse toDTO(Products product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getProductId());
        productResponse.setName(product.getProductName());
        productResponse.setCategory(product.getCategory());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
