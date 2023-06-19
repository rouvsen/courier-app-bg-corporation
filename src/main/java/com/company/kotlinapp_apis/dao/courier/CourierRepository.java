package com.company.kotlinapp_apis.dao.courier;

import com.company.kotlinapp_apis.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findCourierByEmail(String email);
}
