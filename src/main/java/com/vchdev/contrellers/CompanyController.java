package com.vchdev.contrellers;

import com.vchdev.dao.entity.AbstractEntity;
import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.dao.entity.Company;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.CompanyTO;
import com.vchdev.services.CompanyService;
import com.vchdev.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<BaseTO> findAllCompany(){

        return EntityConverter.convertToDTOs(service.findAll());
    }
}
