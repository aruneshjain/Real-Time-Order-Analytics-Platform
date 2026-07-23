package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsDto;
import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsResponse;
import com.arunesh.OrderService.exception.BusinessException;
import com.arunesh.OrderService.repository.OrderMetricsRepository;
import com.arunesh.OrderService.service.OrderMetricsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OrderMetricsServiceImpl implements OrderMetricsService {

    private final OrderMetricsRepository repository;

    public List<OrderMetricsResponse> getMetrics() {
        log.info("Fetching order metrics");
        try {
            List<OrderMetricsResponse> metrics = repository.findAll().stream()
                    .map(OrderMetricsDto::toDTO)
                    .collect(Collectors.toList());
            log.info("Retrieved {} metrics records", metrics.size());
            return metrics;
        } catch (Exception ex) {
            log.error("Error fetching metrics: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to fetch metrics: " + ex.getMessage(), "FETCH_METRICS_FAILED", ex);
        }
    }
}
