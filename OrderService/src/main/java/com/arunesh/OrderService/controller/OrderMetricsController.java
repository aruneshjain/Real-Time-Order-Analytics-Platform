package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.orderMetrics.OrderMetricsResponse;
import com.arunesh.OrderService.service.OrderMetricsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@AllArgsConstructor
@Tag(name = "Order Metrics", description = "Order Analytics and Metrics APIs")
public class OrderMetricsController {
    private final OrderMetricsService service;

    @GetMapping
    @Operation(summary = "Get order metrics", description = "Retrieves analytics and metrics for orders including total orders, revenue, and top products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Metrics retrieved successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderMetricsResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<OrderMetricsResponse> getMetrics() {
        return service.getMetrics();
    }
}
