package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.model.order.Order;
import com.company.kotlinapp_apis.service.inter.order.OrderServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderServiceInter orderService;

    public OrderController(OrderServiceInter orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
