package com.company.kotlinapp_apis.api.shop.controller;

import com.company.kotlinapp_apis.dto.shop.ShopDto;
import com.company.kotlinapp_apis.model.LoginRequest;
import com.company.kotlinapp_apis.service.inter.shop.ShopServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop/login")
public class ShopLoginController {

    private final ShopServiceInter shopService;

    public ShopLoginController(ShopServiceInter shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        ShopDto shopDto = shopService.findShopByEmail(email);

        if (shopDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if(shopDto.getPassword().equals(password)) {
            if(!shopDto.getIsDisable() && !shopDto.getTrash()) {
                return ResponseEntity.ok(shopDto);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted.");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

}
