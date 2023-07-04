package com.company.kotlinapp_apis.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourierDto {

    private Long id;

    @JsonProperty("isDisable")
    private Boolean isDisable;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Integer currentBalance;

    private String familyPhoneNumber;

    private String oneSignal;//deviceId

    private String email;

    private String location;

    private String password;

    private String createdDate;

    private Boolean trash;

    private String trashDate;

}
