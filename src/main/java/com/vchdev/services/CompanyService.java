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

    public void test(){
        List<BaseEntity> baseEntities = new ArrayList<>();

        baseEntities.add(Company.builder().build());
        test2(Company.builder().build());
    }

    public void test2(BaseEntity baseEntity){

    }
}
