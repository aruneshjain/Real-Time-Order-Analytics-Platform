package com.arunesh.OrderService.service;

import com.arunesh.OrderService.dto.alerts.AlertResponse;

import java.util.List;

public interface AlertsService {
    List<AlertResponse> getAlerts();
}
