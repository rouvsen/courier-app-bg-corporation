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
import java.util.Optional;

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
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (adminDto.getFirstName() != null) {
                admin.setFirstName(adminDto.getFirstName());
            }
            if (adminDto.getLastName() != null) {
                admin.setLastName(adminDto.getLastName());
            }
            if (adminDto.getPhoneNumber() != null) {
                admin.setPhoneNumber(adminDto.getPhoneNumber());
            }
            if (adminDto.getCurrentBalance() != null) {
                admin.setCurrentBalance(adminDto.getCurrentBalance());
            }
            if (adminDto.getYourDeptBalance() != null) {
                admin.setYourDeptBalance(adminDto.getYourDeptBalance());
            }
            if (adminDto.getOneSignal() != null) {
                admin.setOneSignal(adminDto.getOneSignal());
            }
            if (adminDto.getEmail() != null) {
                admin.setEmail(adminDto.getEmail());
            }
            if (adminDto.getPassword() != null) {
                admin.setPassword(adminDto.getPassword());
            }
            admin = adminRepository.save(admin);
            return modelMapper.map(admin, AdminDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteAdmin(Long id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            adminRepository.delete(admin);
            return true;
        }
        return false;
    }
}
