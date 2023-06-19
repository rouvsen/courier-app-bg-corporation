package com.company.kotlinapp_apis.dao.shop;

import com.company.kotlinapp_apis.model.admin.Admin;
import com.company.kotlinapp_apis.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findShopByEmail(String email);
}
