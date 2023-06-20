package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.model.order.Order;
import com.company.kotlinapp_apis.service.inter.order.OrderServiceInter;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> deleteOrderById(
            @PathVariable(name = "orderId") Long orderId
    ) {
        orderService.removeById(orderId);
        return ResponseEntity.ok("removed..");
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrderById(
            @PathVariable(name = "orderId") Long orderId
    ) {
        Order order = orderService.getOrderById(orderId);
        if(order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order doesn't exist with given id");
    }



}
