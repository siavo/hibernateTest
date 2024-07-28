package com.vchdev.services;

import com.vchdev.dao.CompanyRepository;
import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.dao.entity.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService extends AbstractService<Company, CompanyRepository> {

    public CompanyService(CompanyRepository repository) {
        super(repository);
    }

}
