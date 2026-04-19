package com.ostap.order_service.controller;

import com.ostap.order_service.model.Order;
import com.ostap.order_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public Order createOrder(
            @RequestBody Order order
    ){
        log.info("Called create method");
        return orderService.createOrder(order);
    }

    @GetMapping("/findAll")
    public List<Order> getAll() {
        log.info("Called getAll method");
        return orderService.findAll();

    }

    @GetMapping("/{id}")
    public Order findById(
            @PathVariable("id") Long id
    ){
        log.info("Called method getById");
        return orderService.findId(id);
    }


    @PatchMapping("/approve/{id}")
    public Order approveOrder(
            @PathVariable("id") Long id
    ){
        log.info("Called method approveOrder");
        return orderService.approveOrder(id);
    }

    @DeleteMapping("/delete/{id}")
    public Order deleteOrder(
            @PathVariable("id") Long id
    ){
        log.info("Called delete method");
        return orderService.deleteOrder(id);
    }

    @GetMapping("/approved")
    public List<Order> findAllApproved() {
        log.info("Called findAllApproved method");
        return orderService.findAllApproved();
    }


}
