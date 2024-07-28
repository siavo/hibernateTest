package com.vchdev.contrellers;

import com.vchdev.dao.entity.Company;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.CompanyTO;
import com.vchdev.services.CompanyService;
import com.vchdev.util.EntityConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
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

    @PostMapping("/add")
    public void addCompany(@RequestBody CompanyTO companyTO){
        service.saveOrUpdate((Company) EntityConverter.convertToEntity(companyTO));
    }
}
