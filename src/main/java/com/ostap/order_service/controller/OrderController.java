package com.ostap.order_service.controller;

import com.ostap.order_service.model.Order;
import com.ostap.order_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;
    private final Repository repository;

    public OrderController(OrderService orderService, Repository repository) {
        this.orderService = orderService;
        this.repository = repository;
    }


    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable("id") Long id
    ){
        return
    }


}
