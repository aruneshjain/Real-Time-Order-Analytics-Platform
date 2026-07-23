package com.arunesh.OrderService.dto.orders;

import com.arunesh.OrderService.dto.products.ProductDto;
import com.arunesh.OrderService.entity.Orders;
import com.arunesh.OrderService.entity.Products;

public class OrderDto {

    public static OrderResponse toDTO(Orders order){
        OrderResponse response = new OrderResponse();

        response.setId(order.getOrderId());
        response.setProduct(ProductDto.toDTO(order.getProduct()));
        response.setAmount(order.getAmount());
        response.setDate(order.getOrderTime());

        return response;
    }

    public static Orders toEntity(OrderResponse response, Products product){
        Orders order = new Orders();

        order.setOrderId(response.getId());
        order.setProduct(product);
        order.setAmount(response.getAmount());
        order.setOrderTime(response.getDate());

        return order;
    }
}
