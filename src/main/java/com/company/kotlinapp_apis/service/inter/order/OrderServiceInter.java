package com.company.kotlinapp_apis.service.inter.order;

import com.company.kotlinapp_apis.model.order.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderServiceInter {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    void removeById(Long orderId);
    Order getOrderById(Long orderId);

    Order updateOrder(Order updatedOrder);
}
