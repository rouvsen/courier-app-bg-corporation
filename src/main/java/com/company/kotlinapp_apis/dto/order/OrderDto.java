package com.company.kotlinapp_apis.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    private String status;

    private Long financeId;

    private Long adminId;

    private Long courierId;

    private Long shopId;

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
