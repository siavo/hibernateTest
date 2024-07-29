package com.vchdev.contrellers;

import com.vchdev.dao.entity.Company;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.CompanyTO;
import com.vchdev.services.CompanyService;
import com.vchdev.util.EntityConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List> findAllCompany() {
        List<BaseTO> companies = new ArrayList<>();
        try{
            companies = EntityConverter.convertToDTOs(service.findAll());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.noContent().build();
        } return ResponseEntity.ok(EntityConverter.convertToDTOs(service.findAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<CompanyTO> addCompany(@RequestBody CompanyTO companyTO){
        try{
            companyTO = (CompanyTO) EntityConverter.convertToDto(service.saveOrUpdate((Company) EntityConverter.convertToEntity(companyTO)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } return new ResponseEntity<>(companyTO, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity updateCompany(@RequestBody CompanyTO companyTO){

        service.saveOrUpdate((Company) EntityConverter.convertToEntity(companyTO));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteCompany(@PathVariable Long id){
        try {
            service.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity("Can not delete company id:" + id, HttpStatus.NOT_ACCEPTABLE);
        } return ResponseEntity.noContent().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CompanyTO> findCompany(@PathVariable Long id){
        CompanyTO companyTO = null;
        try {
            companyTO = (CompanyTO) EntityConverter.convertToDto(service.findById(id).get());
        } catch (Exception e) {
            log.error(e.getMessage());
            new ResponseEntity("Company id:" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(companyTO);
    }
}
