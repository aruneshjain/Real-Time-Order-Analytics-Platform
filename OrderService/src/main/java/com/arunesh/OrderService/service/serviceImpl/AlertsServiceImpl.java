package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.alerts.AlertDto;
import com.arunesh.OrderService.dto.alerts.AlertResponse;
import com.arunesh.OrderService.repository.AlertsRepository;
import com.arunesh.OrderService.service.AlertsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertsServiceImpl implements AlertsService {
    private final AlertsRepository repository;

    public List<AlertResponse> getAlerts() {
        return repository.findAll()
                .stream()
                .map(AlertDto::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }
}
