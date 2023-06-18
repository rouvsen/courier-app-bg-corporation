package com.company.kotlinapp_apis.dto.UserDto;

import com.company.kotlinapp_apis.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto {

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
