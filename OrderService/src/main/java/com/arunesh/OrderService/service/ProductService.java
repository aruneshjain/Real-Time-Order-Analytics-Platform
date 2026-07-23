package com.arunesh.OrderService.service;

import com.arunesh.OrderService.dto.products.ProductRequest;
import com.arunesh.OrderService.dto.products.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse addProduct(ProductRequest product);
}
