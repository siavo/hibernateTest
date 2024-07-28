package com.vchdev.dao;

import com.vchdev.dao.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CommonRepository<Company> {
}
