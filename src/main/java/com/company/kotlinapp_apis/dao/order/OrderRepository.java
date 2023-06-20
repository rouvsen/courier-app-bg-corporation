package com.company.kotlinapp_apis.dao.order;

import com.company.kotlinapp_apis.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
