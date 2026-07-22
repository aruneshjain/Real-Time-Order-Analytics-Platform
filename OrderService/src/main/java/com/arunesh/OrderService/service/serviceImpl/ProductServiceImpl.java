package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.entity.Products;
import com.arunesh.OrderService.repository.ProductRepository;
import com.arunesh.OrderService.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public Products addProduct(Products product) {
        return repository.save(product);
    }

    public List<Products> getAllProducts() {
        return repository.findAll();
    }
}
