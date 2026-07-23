package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.entity.OrderMetrics;
import com.arunesh.OrderService.repository.OrderMetricsRepository;
import com.arunesh.OrderService.service.OrderMetricsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderMetricsServiceImpl implements OrderMetricsService {

    private final OrderMetricsRepository repository;

    public List<OrderMetrics> getMetrics() {
        return repository.findAll();
    }
}
