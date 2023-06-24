package com.company.kotlinapp_apis.service.inter.order;

import com.company.kotlinapp_apis.dto.order.OrderDto;
import com.company.kotlinapp_apis.model.order.Order;

import java.util.List;

public interface OrderServiceInter {
    OrderDto saveOrder(OrderDto order);
    List<OrderDto> getAllOrders();
    void removeById(Long orderId);
    Order getOrderById(Long orderId);
    OrderDto updateOrder(Order orderDto);
}
