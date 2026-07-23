package com.arunesh.OrderService.controller;

import com.arunesh.OrderService.dto.alerts.AlertResponse;
import com.arunesh.OrderService.service.AlertsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@AllArgsConstructor
public class AlertsController {
    private final AlertsService service;

    @GetMapping
    public List<AlertResponse> getAlerts() { return service.getAlerts(); }
}
