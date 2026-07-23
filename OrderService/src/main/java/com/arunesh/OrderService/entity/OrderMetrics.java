package com.arunesh.OrderService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_metrics", schema = "OrderService")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metricId;

    @Column(name = "metric_date", nullable = false)
    private java.sql.Date metricDate;

    @Column(name = "total_orders", nullable = false)
    private Integer totalOrders;

    @Column(name = "total_revenue", nullable = false)
    private Double totalRevenue;

    @Column(name = "top_product")
    private String topProduct;

}
