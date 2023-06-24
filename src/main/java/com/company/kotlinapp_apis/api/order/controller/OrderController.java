package com.company.kotlinapp_apis.api.order.controller;

import com.company.kotlinapp_apis.dto.order.OrderDto;
import com.company.kotlinapp_apis.service.impl.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.findOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(
            @PathVariable Long orderId,
            @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderId, orderDto);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        boolean deleted = orderService.deleteOrder(orderId);
        if (deleted) {
            return ResponseEntity.ok("Order deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
