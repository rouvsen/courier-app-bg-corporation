package com.company.kotlinapp_apis.dto.order;

import com.company.kotlinapp_apis.model.admin.Admin;
import com.company.kotlinapp_apis.model.courier.Courier;
import com.company.kotlinapp_apis.model.shop.Shop;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDto {

    private Long id;

    private String name;

    private Admin admin;

    private Courier courier;

    private Shop shop;

}
