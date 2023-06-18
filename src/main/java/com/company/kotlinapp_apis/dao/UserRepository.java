package com.company.kotlinapp_apis.dao;

import com.company.kotlinapp_apis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //methods
}
