package com.company.kotlinapp_apis.service.inter.shop;

import com.company.kotlinapp_apis.dto.shop.ShopDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopServiceInter {

    List<ShopDto> getAllShops();
    ShopDto getShopById(Long id);
    ResponseEntity<ShopDto> createShop(ShopDto shopDto);
    ShopDto updateShop(Long id, ShopDto shopDto);
    void deleteShopById(Long id);
    Boolean isShopEmailTaken(String email);
    ShopDto findShopByEmail(String email);
}
