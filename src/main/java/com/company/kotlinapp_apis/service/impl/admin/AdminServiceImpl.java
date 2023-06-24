package com.company.kotlinapp_apis.service.impl.admin;

import com.company.kotlinapp_apis.dao.admin.AdminRepository;
import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.model.admin.Admin;
import com.company.kotlinapp_apis.service.inter.admin.AdminServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminServiceInter {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<AdminDto> createAdmin(AdminDto adminDto) {
        Admin adminEntity = modelMapper.map(adminDto, Admin.class);
        if(isAdminEmailTaken(adminEntity.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Admin savedAdmin = adminRepository.save(adminEntity);
        return ResponseEntity.ok(modelMapper.map(savedAdmin, AdminDto.class));
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<AdminDto> listDto = new ArrayList<>();

        List<Admin> listEntity = adminRepository.findAll();

        for (Admin entity : listEntity) {
            AdminDto dto = modelMapper.map(entity, AdminDto.class);
            listDto.add(dto);
        }

        return listDto;
    }

    @Override
    public AdminDto getAdminById(Long id) {
        Admin entity = adminRepository.findById(id).orElseGet(() -> null);
        if(entity != null) {
            return modelMapper.map(entity, AdminDto.class);
        }
        return null;
    }

    @Override
    public AdminDto findAdminByEmail(String email) {
        Admin admin = adminRepository.findAdminByEmail(email);
        if(admin != null) {
            return modelMapper.map(admin, AdminDto.class);
        }
        return null;
    }

    @Override
    public Boolean isAdminEmailTaken(String email) {
        return adminRepository.findAdminByEmail(email) != null;
    }

    @Override
    public AdminDto updateAdmin(Long id, AdminDto adminDto) {
        return null;
    }

    @Override
    public Boolean deleteAdmin(Long id) {
        return null;
    }
}
