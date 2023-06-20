package com.company.kotlinapp_apis.service.impl.order;

import com.company.kotlinapp_apis.dao.order.OrderRepository;
import com.company.kotlinapp_apis.model.order.Order;
import com.company.kotlinapp_apis.service.inter.order.OrderServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceInter {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
