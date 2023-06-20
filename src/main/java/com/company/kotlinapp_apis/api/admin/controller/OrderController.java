package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.model.order.Order;
import com.company.kotlinapp_apis.service.inter.order.OrderServiceInter;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderServiceInter orderService;

    public OrderController(OrderServiceInter orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrderById(
            @PathVariable(name = "orderId") Long orderId
    ) {
        orderService.removeById(orderId);
        return ResponseEntity.ok("removed..");
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(
            @PathVariable(name = "orderId") Long orderId
    ) {
        Order order = orderService.getOrderById(orderId);
        if(order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order doesn't exist with given id");
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrderById(
            @RequestBody Order updatedOrder,
            @PathVariable("orderId") Long orderId) {

        Order existingOrder = orderService.getOrderById(orderId);

        if (existingOrder == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            existingOrder.setStatus(updatedOrder.getStatus());
            existingOrder.setFinanceId(updatedOrder.getFinanceId());
            existingOrder.setAdminId(updatedOrder.getAdminId());
            existingOrder.setCourierId(updatedOrder.getCourierId());
            existingOrder.setShopId(updatedOrder.getShopId());
            existingOrder.setCustomerContact(updatedOrder.getCustomerContact());
            existingOrder.setToLocation(updatedOrder.getToLocation());
            existingOrder.setItemPrice(updatedOrder.getItemPrice());
            existingOrder.setDeliveryPrice(updatedOrder.getDeliveryPrice());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            existingOrder.setPickupCourierPrice(updatedOrder.getPickupCourierPrice());
            existingOrder.setCreatedDate(updatedOrder.getCreatedDate());
            existingOrder.setCallCourierDate(updatedOrder.getCallCourierDate());
            existingOrder.setToShopDate(updatedOrder.getToShopDate());
            existingOrder.setToCustomerDate(updatedOrder.getToCustomerDate());
            existingOrder.setSuccessDate(updatedOrder.getSuccessDate());
            existingOrder.setReturnDate(updatedOrder.getReturnDate());
            existingOrder.setCreatedTime(updatedOrder.getCreatedTime());
            existingOrder.setCallCourierTime(updatedOrder.getCallCourierTime());
            existingOrder.setToShopTime(updatedOrder.getToShopTime());
            existingOrder.setToCustomerTime(updatedOrder.getToCustomerTime());
            existingOrder.setSuccessTime(updatedOrder.getSuccessTime());
            existingOrder.setReturnTime(updatedOrder.getReturnTime());
            existingOrder.setDescription(updatedOrder.getDescription());
            existingOrder.setSelectableItem(updatedOrder.getSelectableItem());
            existingOrder.setPaidOrder(updatedOrder.getPaidOrder());
            existingOrder.setOrderTrash(updatedOrder.getOrderTrash());
            existingOrder.setOrderTrashDate(updatedOrder.getOrderTrashDate());
        } catch (OptimisticLockException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("please, try it after just a moment..");
        }

        return ResponseEntity.ok(orderService.updateOrder(existingOrder));
    }

}
