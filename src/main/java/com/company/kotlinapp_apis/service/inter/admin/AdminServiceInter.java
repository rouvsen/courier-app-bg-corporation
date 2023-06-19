package com.company.kotlinapp_apis.service.inter.admin;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminServiceInter {

    List<AdminDto> getAllAdmins();
    AdminDto getAdminById(Long id);
    ResponseEntity<AdminDto> createAdmin(AdminDto adminDto);
    AdminDto updateAdmin(Long id, AdminDto adminDto);
    Boolean deleteAdmin(Long id);
    Boolean isAdminEmailTaken(String email);
    AdminDto findAdminByEmail(String email);

}
