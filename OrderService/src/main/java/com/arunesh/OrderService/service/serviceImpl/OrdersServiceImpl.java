package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.orders.OrderDto;
import com.arunesh.OrderService.dto.orders.OrderRequest;
import com.arunesh.OrderService.dto.orders.OrderResponse;
import com.arunesh.OrderService.entity.Orders;
import com.arunesh.OrderService.entity.Products;
import com.arunesh.OrderService.exception.BusinessException;
import com.arunesh.OrderService.exception.ResourceNotFoundException;
import com.arunesh.OrderService.repository.OrdersRepository;
import com.arunesh.OrderService.repository.ProductRepository;
import com.arunesh.OrderService.service.OrdersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productsRepository;

    public OrderResponse createOrder(OrderRequest request) {
        log.info("Creating order for product: {}", request.getProductId());

        Products product = productsRepository.findById(request.getProductId())
                .orElseThrow(() -> {
                    log.error("Product not found with ID: {}", request.getProductId());
                    return new ResourceNotFoundException("Product", "productId", request.getProductId());
                });

        try {
            Orders order = Orders.builder()
                    .orderId(UUID.randomUUID().toString())
                    .product(product)
                    .amount(request.getAmount())
                    .orderTime(Instant.now())
                    .build();

            Orders savedOrder = ordersRepository.save(order);
            log.info("Order created successfully with ID: {}", savedOrder.getOrderId());
            return OrderDto.toDTO(savedOrder);
        } catch (Exception ex) {
            log.error("Error creating order: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to create order: " + ex.getMessage(), "ORDER_CREATION_FAILED", ex);
        }
    }

    public List<OrderResponse> getAllOrders() {
        log.info("Fetching all orders");
        try {
            return ordersRepository.findAll()
                    .stream()
                    .map(OrderDto::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            log.error("Error fetching orders: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to fetch orders: " + ex.getMessage(), "FETCH_ORDERS_FAILED", ex);
        }
    }

    public long countOrdersByProduct(String productId) {
        log.info("Counting orders for product: {}", productId);

        if (productId == null || productId.trim().isEmpty()) {
            log.warn("Invalid product ID provided");
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }

        try {
            long count = ordersRepository.countByProduct_ProductId(productId);
            log.info("Found {} orders for product: {}", count, productId);
            return count;
        } catch (Exception ex) {
            log.error("Error counting orders: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to count orders: " + ex.getMessage(), "COUNT_ORDERS_FAILED", ex);
        }
    }
}
