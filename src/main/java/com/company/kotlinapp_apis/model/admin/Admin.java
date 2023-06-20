package com.company.kotlinapp_apis.model.admin;

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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<Order> orders;

    private String oneSignal;//deviceId

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
