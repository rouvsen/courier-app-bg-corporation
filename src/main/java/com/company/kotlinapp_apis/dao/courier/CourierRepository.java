package com.company.kotlinapp_apis.dao.courier;

import com.company.kotlinapp_apis.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

//    @Query("SELECT c FROM Courier c WHERE c.email = :email")
    Courier findCourierByEmail(String email); // @Param("email")
}
