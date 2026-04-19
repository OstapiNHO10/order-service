package com.ostap.order_service.service;

import com.ostap.order_service.entity.OrderEntity;
import com.ostap.order_service.model.Order;
import com.ostap.order_service.model.OrderStatus;
import com.ostap.order_service.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository repository, OrderMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }


    public Order createOrder(Order order) {

        var orderEntity = orderMapper.toEntity(order);

        var createdOrder = repository.save(orderEntity);
        return orderMapper.toDomain(createdOrder);



    }

    public List<Order> findAll() {
        List<OrderEntity> allEntities = repository.findAll();

        return allEntities.stream()
                .map(orderMapper::toDomain)
                .toList();


    }

    public Order findId(Long id) {
        var orderEntity = repository.findById(id)
                .orElseThrow();
        Order order = orderMapper.toDomain(orderEntity);
        return order;
    }

    public Order approveOrder(Long id) {
        var orderEntity = repository.findById(id)
                .orElseThrow();
        if (orderEntity.getOrderStatus().equals(OrderStatus.PENDING)) {
            orderEntity.setOrderStatus(OrderStatus.APPROVED);
        } else {
            throw new IllegalStateException("Status can't be changed");
        }
        var savedOrder = repository.save(orderEntity);
        return orderMapper.toDomain(savedOrder);
    }

    public Order deleteOrder(Long id) {
        var orderEntity = repository.findById(id)
                .orElseThrow();

        if (orderEntity.getId().equals(id)) {
            repository.delete(orderEntity);
        } else {
            throw new EntityNotFoundException("Not found entity with id= " + id);
        }
        return orderMapper.toDomain(orderEntity);
    }

    public List<Order> findAllApproved() {

        List<OrderEntity> allEntities = repository.findAll();

        return allEntities.stream()
                .filter(r -> r.getOrderStatus() == OrderStatus.APPROVED)
                .map(orderMapper::toDomain)
                .toList();
    }
}
