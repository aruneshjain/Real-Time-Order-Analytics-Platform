package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.entity.Orders;
import com.arunesh.OrderService.repository.OrdersRepository;
import com.arunesh.OrderService.service.OrdersService;
import lombok.AllArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository repository;

    public Orders createOrder(String productId, Double amount) {
        Orders order = new Orders(
                UUID.randomUUID().toString(),
                productId,
                amount,
                Instant.now()
        );
        return repository.save(order);
    }

    public List<Orders> getAllOrders() {
        return repository.findAll();
    }

    public long countOrdersByProduct(String productId) {
        return repository.countByProductId(productId);
    }
}
