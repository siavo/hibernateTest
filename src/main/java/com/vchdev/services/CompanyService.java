package com.vchdev.services;

import com.vchdev.dao.CompanyRepository;
import com.vchdev.dao.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<Company, CompanyRepository> {

    public CompanyService(CompanyRepository repository) {
        super(repository);
    }
}
