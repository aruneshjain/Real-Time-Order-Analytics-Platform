package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.orders.OrderRequest;
import com.arunesh.OrderService.dto.orders.OrderResponse;
import com.arunesh.OrderService.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/orders")
@AllArgsConstructor
@Tag(name = "Orders", description = "Order Management APIs")
public class OrdersController {

    private final OrdersService service;

    @PostMapping
    @Operation(summary = "Create a new order", description = "Creates a new order in the system with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid order request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieves a list of all orders in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders retrieved successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<OrderResponse> getOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/count/{productId}")
    @Operation(summary = "Count orders by product", description = "Counts the total number of orders for a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order count retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid product ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public long countOrders(
            @Parameter(description = "Product ID to count orders for", example = "P001", required = true)
            @PathVariable String productId) {
        return service.countOrdersByProduct(productId);
    }
}
