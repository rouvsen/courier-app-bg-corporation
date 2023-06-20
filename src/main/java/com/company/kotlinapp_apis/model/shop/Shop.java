package com.company.kotlinapp_apis.model.shop;

import com.company.kotlinapp_apis.model.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String latLong;

    private String location;

    private String phoneNumber;

    private String oneSignal;//deviceId

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String createdDate;

    private Boolean trash;

    private String trashDate;
}
