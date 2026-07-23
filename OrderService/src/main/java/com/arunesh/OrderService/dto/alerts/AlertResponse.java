package com.arunesh.OrderService.dto.alerts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class AlertResponse {

    @NotNull(message = "Alert ID cannot be null")
    private Long id;

    @NotBlank(message = "Alert type cannot be blank")
    private String type;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Created date cannot be null")
    private Instant createdAt;
}
