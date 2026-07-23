package com.arunesh.OrderService.dto.alerts;

import com.arunesh.OrderService.entity.Alerts;

public class AlertDto {

    public static AlertResponse toDTO(Alerts alert){

        AlertResponse response = new AlertResponse();

        response.setId(alert.getAlertId());
        response.setType(alert.getAlertType());
        response.setDescription(alert.getDescription());
        response.setCreatedAt(alert.getCreatedAt());

        return response;
    }
}
