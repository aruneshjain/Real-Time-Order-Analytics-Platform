package com.arunesh.OrderService.dto.alerts;

import lombok.Data;

import java.time.Instant;

@Data
public class AlertResponse {

    private Long id;
    private String type;
    private String description;
    private Instant createdAt;
}
