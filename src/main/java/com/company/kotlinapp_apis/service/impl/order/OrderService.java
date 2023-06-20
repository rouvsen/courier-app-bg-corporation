package com.company.kotlinapp_apis.service.impl.order;

import com.company.kotlinapp_apis.dao.admin.AdminRepository;
import com.company.kotlinapp_apis.dao.courier.CourierRepository;
import com.company.kotlinapp_apis.dao.order.OrderRepository;
import com.company.kotlinapp_apis.dao.shop.ShopRepository;
import com.company.kotlinapp_apis.model.order.Order;
import com.company.kotlinapp_apis.service.inter.order.OrderServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceInter {

    private final OrderRepository orderRepository;

    private final AdminRepository adminRepository;
    private final CourierRepository courierRepository;
    private final ShopRepository shopRepository;

    public OrderService(OrderRepository orderRepository, AdminRepository adminRepository, CourierRepository courierRepository, ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.adminRepository = adminRepository;
        this.courierRepository = courierRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void removeById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseGet(() -> null);
    }

    @Override
    public Order updateOrder(Order updatedOrder) {
        return orderRepository.save(updatedOrder);
    }
}
