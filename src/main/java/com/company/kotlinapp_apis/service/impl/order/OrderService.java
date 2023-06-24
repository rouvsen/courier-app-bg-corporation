package com.company.kotlinapp_apis.service.impl.order;

import com.company.kotlinapp_apis.dao.order.OrderRepository;
import com.company.kotlinapp_apis.dto.order.OrderDto;
import com.company.kotlinapp_apis.model.order.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService { //implements OrderServiceInter

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order = orderRepository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    public OrderDto findOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(order -> modelMapper.map(order, OrderDto.class)).orElse(null);
    }

    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            modelMapper.map(orderDto, order);
            order = orderRepository.save(order);
            return modelMapper.map(order, OrderDto.class);
        }
        return null;
    }

    public boolean deleteOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderRepository.delete(order);
            return true;
        }
        return false;
    }
}
