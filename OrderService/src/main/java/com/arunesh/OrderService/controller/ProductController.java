package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.products.ProductRequest;
import com.arunesh.OrderService.dto.products.ProductResponse;
import com.arunesh.OrderService.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return service.getAllProducts();
    }
}
