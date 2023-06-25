package com.company.kotlinapp_apis.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Integer currentBalance;

    private Integer yourDeptBalance;

    private String oneSignal;//deviceId

    private String email;

    private String password;

}
