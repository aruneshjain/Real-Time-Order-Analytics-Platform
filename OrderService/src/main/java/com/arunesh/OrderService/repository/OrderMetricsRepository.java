package com.arunesh.OrderService.repository;

import com.arunesh.OrderService.entity.OrderMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMetricsRepository extends JpaRepository<OrderMetrics, Long> {
}
