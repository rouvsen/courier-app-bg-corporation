package com.company.kotlinapp_apis.dto.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShopDto {

    private Long id;

    private String firstName;

    private String latLong;

    private String phoneNumber;

    private String location;

    private String oneSignal;//deviceId

    private String email;

    private String password;

    private String createdDate;

    private Boolean trash;

    private String trashDate;

}
