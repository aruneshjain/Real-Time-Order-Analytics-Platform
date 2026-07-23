package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.products.ProductDto;
import com.arunesh.OrderService.dto.products.ProductRequest;
import com.arunesh.OrderService.dto.products.ProductResponse;
import com.arunesh.OrderService.repository.ProductRepository;
import com.arunesh.OrderService.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductResponse addProduct(ProductRequest product) {
        return ProductDto.toDTO(repository.save(ProductDto.toEntity(product)));
    }

    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductDto::toDTO)
                .collect(Collectors.toList());
    }
}
