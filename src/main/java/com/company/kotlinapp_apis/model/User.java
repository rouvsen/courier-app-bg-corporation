package com.company.kotlinapp_apis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String oneSignal;//deviceId

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
