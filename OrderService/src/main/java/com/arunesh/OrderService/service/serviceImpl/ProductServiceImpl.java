package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.products.ProductDto;
import com.arunesh.OrderService.dto.products.ProductRequest;
import com.arunesh.OrderService.dto.products.ProductResponse;
import com.arunesh.OrderService.exception.BusinessException;
import com.arunesh.OrderService.repository.ProductRepository;
import com.arunesh.OrderService.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductResponse addProduct(ProductRequest product) {
        log.info("Adding new product: {}", product.getName());

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            log.warn("Invalid product request");
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        try {
            ProductResponse savedProduct = ProductDto.toDTO(repository.save(ProductDto.toEntity(product)));
            log.info("Product added successfully with ID: {}", savedProduct.getId());
            return savedProduct;
        } catch (Exception ex) {
            log.error("Error adding product: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to add product: " + ex.getMessage(), "PRODUCT_ADD_FAILED", ex);
        }
    }

    public List<ProductResponse> getAllProducts() {
        log.info("Fetching all products");
        try {
            List<ProductResponse> products = repository.findAll()
                    .stream()
                    .map(ProductDto::toDTO)
                    .collect(Collectors.toList());
            log.info("Retrieved {} products", products.size());
            return products;
        } catch (Exception ex) {
            log.error("Error fetching products: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to fetch products: " + ex.getMessage(), "FETCH_PRODUCTS_FAILED", ex);
        }
    }
}
