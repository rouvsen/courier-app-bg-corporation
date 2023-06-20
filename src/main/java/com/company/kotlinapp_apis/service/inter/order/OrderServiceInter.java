package com.company.kotlinapp_apis.service.inter.order;

import com.company.kotlinapp_apis.model.order.Order;

import java.util.List;

public interface OrderServiceInter {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
}
