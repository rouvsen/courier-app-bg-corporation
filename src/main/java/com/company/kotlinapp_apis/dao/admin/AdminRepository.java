package com.company.kotlinapp_apis.dao.admin;

import com.company.kotlinapp_apis.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmail(String email);
}
