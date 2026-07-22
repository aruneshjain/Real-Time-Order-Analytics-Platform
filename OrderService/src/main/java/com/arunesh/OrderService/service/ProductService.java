package com.arunesh.OrderService.service;

import com.arunesh.OrderService.entity.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();

    Products addProduct(Products product);
}
