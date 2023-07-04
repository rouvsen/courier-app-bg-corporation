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

            if (orderDto.getStatus() != null) {
                order.setStatus(orderDto.getStatus());
            }
            if (orderDto.getAdminId() != null) {
                order.setAdminId(orderDto.getAdminId());
            }
            if (orderDto.getCourierId() != null) {
                order.setCourierId(orderDto.getCourierId());
            }
            if (orderDto.getShopId() != null) {
                order.setShopId(orderDto.getShopId());
            }
            if (orderDto.getReturnLocation() != null) {
                order.setReturnLocation(orderDto.getReturnLocation());
            }
            if (orderDto.getCustomerContact() != null) {
                order.setCustomerContact(orderDto.getCustomerContact());
            }
            if (orderDto.getToLocation() != null) {
                order.setToLocation(orderDto.getToLocation());
            }
            if (orderDto.getItemPrice() != null) {
                order.setItemPrice(orderDto.getItemPrice());
            }
            if (orderDto.getDeliveryPrice() != null) {
                order.setDeliveryPrice(orderDto.getDeliveryPrice());
            }
            if (orderDto.getTotalPrice() != null) {
                order.setTotalPrice(orderDto.getTotalPrice());
            }
            if (orderDto.getPickupCourierPrice() != null) {
                order.setPickupCourierPrice(orderDto.getPickupCourierPrice());
            }
            if (orderDto.getCreatedDate() != null) {
                order.setCreatedDate(orderDto.getCreatedDate());
            }
            if (orderDto.getCallCourierDate() != null) {
                order.setCallCourierDate(orderDto.getCallCourierDate());
            }
            if (orderDto.getToShopDate() != null) {
                order.setToShopDate(orderDto.getToShopDate());
            }
            if (orderDto.getToCustomerDate() != null) {
                order.setToCustomerDate(orderDto.getToCustomerDate());
            }
            if (orderDto.getSuccessDate() != null) {
                order.setSuccessDate(orderDto.getSuccessDate());
            }
            if (orderDto.getReturnDate() != null) {
                order.setReturnDate(orderDto.getReturnDate());
            }
            if (orderDto.getCreatedTime() != null) {
                order.setCreatedTime(orderDto.getCreatedTime());
            }
            if (orderDto.getCallCourierTime() != null) {
                order.setCallCourierTime(orderDto.getCallCourierTime());
            }
            if (orderDto.getToShopTime() != null) {
                order.setToShopTime(orderDto.getToShopTime());
            }
            if (orderDto.getToCustomerTime() != null) {
                order.setToCustomerTime(orderDto.getToCustomerTime());
            }
            if (orderDto.getSuccessTime() != null) {
                order.setSuccessTime(orderDto.getSuccessTime());
            }
            if (orderDto.getReturnTime() != null) {
                order.setReturnTime(orderDto.getReturnTime());
            }
            if (orderDto.getDescription() != null) {
                order.setDescription(orderDto.getDescription());
            }
            if (orderDto.getSelectableItem() != null) {
                order.setSelectableItem(orderDto.getSelectableItem());
            }
            if (orderDto.getOrderTrash() != null) {
                order.setOrderTrash(orderDto.getOrderTrash());
            }
            if (orderDto.getOrderTrashDate() != null) {
                order.setOrderTrashDate(orderDto.getOrderTrashDate());
            }

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
