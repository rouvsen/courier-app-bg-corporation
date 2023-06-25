package com.company.kotlinapp_apis.dao.finance;

import com.company.kotlinapp_apis.model.finance.AdminYourDeptBalanceDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminYourDeptBalanceDetRepository
        extends JpaRepository<AdminYourDeptBalanceDet, Long> {
}
