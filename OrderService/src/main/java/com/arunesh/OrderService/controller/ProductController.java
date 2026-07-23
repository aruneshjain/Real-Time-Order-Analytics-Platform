package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.products.ProductRequest;
import com.arunesh.OrderService.dto.products.ProductResponse;
import com.arunesh.OrderService.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Tag(name = "Products", description = "Product Management APIs")
public class ProductController {

    private final ProductService service;

    @PostMapping
    @Operation(summary = "Add a new product", description = "Adds a new product to the catalog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid product request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest product) {
        return service.addProduct(product);
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all products in the catalog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<ProductResponse> getProducts() {
        return service.getAllProducts();
    }
}
