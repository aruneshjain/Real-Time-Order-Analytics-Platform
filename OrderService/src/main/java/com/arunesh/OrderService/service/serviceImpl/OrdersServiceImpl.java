package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.orders.OrderDto;
import com.arunesh.OrderService.dto.orders.OrderRequest;
import com.arunesh.OrderService.dto.orders.OrderResponse;
import com.arunesh.OrderService.entity.Orders;
import com.arunesh.OrderService.entity.Products;
import com.arunesh.OrderService.repository.OrdersRepository;
import com.arunesh.OrderService.repository.ProductRepository;
import com.arunesh.OrderService.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productsRepository;

    public OrderResponse createOrder(OrderRequest request) {

        Products product = productsRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return
                OrderDto.toDTO(ordersRepository.save(Orders.builder()
                        .orderId(UUID.randomUUID().toString())
                        .product(product)
                        .amount(request.getAmount())
                        .orderTime(Instant.now())
                        .build())
                );


    }

    public List<OrderResponse> getAllOrders() {
        return ordersRepository.findAll()
                .stream()
                .map(OrderDto::toDTO)
                .collect(Collectors.toList());
    }

    public long countOrdersByProduct(String productId) {
        return ordersRepository.countByProduct_ProductId(productId);
    }
}
