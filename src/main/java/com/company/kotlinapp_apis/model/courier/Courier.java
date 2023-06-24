package com.company.kotlinapp_apis.model.courier;

import com.company.kotlinapp_apis.model.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_disable")
    private boolean isDisable;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String location;

    private String familyPhoneNumber;

    private String oneSignal;//deviceId

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String createdDate;

    private boolean courierTrash;

    private String trashDate;
}
