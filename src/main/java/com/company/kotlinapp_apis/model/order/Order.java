package com.company.kotlinapp_apis.model.order;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version; // Optimistic locking

    private String status;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "courier_id")
    private Long courierId;

    @Column(name = "shop_id")
    private Long shopId;

    private String returnLocation;

    private String customerContact;

    private String toLocation;

    private Integer itemPrice;

    private Integer deliveryPrice;

    private Integer totalPrice;

    private Integer pickupCourierPrice;

    private String createdDate;

    private String callCourierDate;

    private String toShopDate;

    private String toCustomerDate;

    private String successDate;

    private String returnDate;

    private String createdTime;

    private String callCourierTime;

    private String toShopTime;

    private String toCustomerTime;

    private String successTime;

    private String returnTime;

    private String description;

    private Boolean selectableItem;

    private Boolean orderTrash;

    private String orderTrashDate;

}
