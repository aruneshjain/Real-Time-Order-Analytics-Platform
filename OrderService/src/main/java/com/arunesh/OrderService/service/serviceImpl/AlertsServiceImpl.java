package com.arunesh.OrderService.service.serviceImpl;

import com.arunesh.OrderService.dto.alerts.AlertDto;
import com.arunesh.OrderService.dto.alerts.AlertResponse;
import com.arunesh.OrderService.exception.BusinessException;
import com.arunesh.OrderService.repository.AlertsRepository;
import com.arunesh.OrderService.service.AlertsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class AlertsServiceImpl implements AlertsService {
    private final AlertsRepository repository;

    public List<AlertResponse> getAlerts() {
        log.info("Fetching all alerts");
        try {
            List<AlertResponse> alerts = repository.findAll()
                    .stream()
                    .map(AlertDto::toDTO)
                    .collect(Collectors.toList());
            log.info("Retrieved {} alerts", alerts.size());
            return alerts;
        } catch (Exception ex) {
            log.error("Error fetching alerts: {}", ex.getMessage(), ex);
            throw new BusinessException("Failed to fetch alerts: " + ex.getMessage(), "FETCH_ALERTS_FAILED", ex);
        }
    }
}
