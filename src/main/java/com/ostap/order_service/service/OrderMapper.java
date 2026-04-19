package com.ostap.order_service.service;

import com.ostap.order_service.entity.OrderEntity;
import com.ostap.order_service.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toDomain(OrderEntity order) {
        return new Order(
                order.getId(),
                order.getUserId(),
                order.getTime(),
                order.getPrice(),
                order.getOrderStatus()
        );
    }

    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.id(),
                order.userId(),
                order.time(),
                order.price(),
                order.orderStatus()
        );
    }
}
