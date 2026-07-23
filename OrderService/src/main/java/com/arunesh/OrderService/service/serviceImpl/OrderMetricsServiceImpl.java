package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsDto;
import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsResponse;
import com.arunesh.OrderService.repository.OrderMetricsRepository;
import com.arunesh.OrderService.service.OrderMetricsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderMetricsServiceImpl implements OrderMetricsService {

    private final OrderMetricsRepository repository;

    public List<OrderMetricsResponse> getMetrics() {
        return repository.findAll().stream()
                .map(OrderMetricsDto::toDTO)
                .collect(Collectors.toList());
    }
}
