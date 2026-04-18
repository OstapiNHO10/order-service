package com.ostap.order_service.service;

import com.ostap.order_service.model.Order;
import com.ostap.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }



}
