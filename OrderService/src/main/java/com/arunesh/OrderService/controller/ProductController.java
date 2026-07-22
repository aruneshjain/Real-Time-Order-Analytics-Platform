package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.entity.Products;
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
    public Products addProduct(@RequestBody Products product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Products> getProducts() {
        return service.getAllProducts();
    }
}
