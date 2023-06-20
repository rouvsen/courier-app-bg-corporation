package com.company.kotlinapp_apis.model.order;

import com.company.kotlinapp_apis.model.admin.Admin;
import com.company.kotlinapp_apis.model.courier.Courier;
import com.company.kotlinapp_apis.model.finance.Finance;
import com.company.kotlinapp_apis.model.shop.Shop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Finance finance;

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

    private Boolean paidOrder;

    private Boolean orderTrash;

    private String orderTrashDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

}
