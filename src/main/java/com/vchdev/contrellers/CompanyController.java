package com.vchdev.contrellers;

import com.vchdev.dao.entity.Company;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.CompanyTO;
import com.vchdev.services.CompanyService;
import com.vchdev.util.EntityConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity addCompany(@RequestBody CompanyTO companyTO){
        return new ResponseEntity<>(EntityConverter.convertToDto(service.saveOrUpdate((Company) EntityConverter.convertToEntity(companyTO))), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateCompany(@RequestBody CompanyTO companyTO){
        service.saveOrUpdate((Company) EntityConverter.convertToEntity(companyTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteCompany(@RequestBody Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/show")
    public ResponseEntity<?> findCompany(@RequestBody Long id){
        Optional<Company> company = service.findById(id);
        return company.map(value -> ResponseEntity.ok(EntityConverter.convertToDto(value))).
                orElseGet(() -> new ResponseEntity("Company not found.", HttpStatus.NOT_ACCEPTABLE));
    }
}
