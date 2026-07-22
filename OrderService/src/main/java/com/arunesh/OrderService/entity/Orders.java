package com.arunesh.OrderService.entity;

import jakarta.persistence.*;
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

        // ✅ Many-to-One relationship with Products
        @ManyToOne(fetch = FetchType.EAGER) // EAGER ensures product details are loaded with the order
        @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
        private Products product;

        @Column(name = "amount", nullable = false)
        private Double amount;

        @Column(name = "order_time", nullable = false)
        private Instant orderTime;
}