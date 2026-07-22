package com.arunesh.OrderService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "orders", schema = "OrderService")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
        @Id
        @Column(name = "order_id", length = 50)
        private String orderId;

        @Column(name = "product_id", nullable = false, length = 50)
        private String productId;

        @Column(name = "amount", nullable = false)
        private Double amount;

        @Column(name = "order_time", nullable = false)
        private Instant orderTime;
}