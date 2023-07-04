package com.company.kotlinapp_apis.service.impl.shop;

import com.company.kotlinapp_apis.dao.shop.ShopRepository;
import com.company.kotlinapp_apis.dto.shop.ShopDto;
import com.company.kotlinapp_apis.model.shop.Shop;
import com.company.kotlinapp_apis.service.inter.shop.ShopServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopServiceInter {

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ShopDto> createShop(ShopDto shopDto) {
        Shop shopEntity = modelMapper.map(shopDto, Shop.class);
        if(isShopEmailTaken(shopEntity.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        shopEntity.setIsDisable(false);
        shopEntity.setTrash(false);
        Shop savedShop = shopRepository.save(shopEntity);
        return ResponseEntity.ok(modelMapper.map(savedShop, ShopDto.class));
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<ShopDto> listDto = new ArrayList<>();

        List<Shop> listEntity = shopRepository.findAll();

        for (Shop entity : listEntity) {
            ShopDto dto = modelMapper.map(entity, ShopDto.class);
            listDto.add(dto);
        }

        return listDto;
    }

    @Override
    public ShopDto getShopById(Long id) {
        Shop entity = shopRepository.findById(id).orElseGet(() -> null);
        if (entity != null) {
            return modelMapper.map(entity, ShopDto.class);
        }
        return null;
    }

    @Override
    public Boolean isShopEmailTaken(String email) {
        return shopRepository.findShopByEmail(email) != null;
    }

    @Override
    public ShopDto findShopByEmail(String email) {
        Shop shop = shopRepository.findShopByEmail(email);
        if(shop != null) {
            return modelMapper.map(shop, ShopDto.class);
        }
        return null;
    }

    @Override
    public ShopDto updateShop(Long id, ShopDto shopDto) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();

            if (shopDto.getIsDisable() != null) {
                shop.setIsDisable(shopDto.getIsDisable());
            }
            if (shopDto.getFirstName() != null) {
                shop.setFirstName(shopDto.getFirstName());
            }
            if (shopDto.getLatLong() != null) {
                shop.setLatLong(shopDto.getLatLong());
            }
            if (shopDto.getLocation() != null) {
                shop.setLocation(shopDto.getLocation());
            }
            if (shopDto.getPhoneNumber() != null) {
                shop.setPhoneNumber(shopDto.getPhoneNumber());
            }
            if (shopDto.getOneSignal() != null) {
                shop.setOneSignal(shopDto.getOneSignal());
            }
            if (shopDto.getEmail() != null) {
                shop.setEmail(shopDto.getEmail());
            }
            if (shopDto.getPassword() != null) {
                shop.setPassword(shopDto.getPassword());
            }
            if (shopDto.getCreatedDate() != null) {
                shop.setCreatedDate(shopDto.getCreatedDate());
            }
            if (shopDto.getTrash() != null) {
                shop.setTrash(shopDto.getTrash());
            }
            if (shopDto.getTrashDate() != null) {
                shop.setTrashDate(shopDto.getTrashDate());
            }

            shop = shopRepository.save(shop);
            return modelMapper.map(shop, ShopDto.class);
        }
        return null;
    }


    @Override
    public void deleteShopById(Long id) {
        shopRepository.deleteById(id);
    }
}
