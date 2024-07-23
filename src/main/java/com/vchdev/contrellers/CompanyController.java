package com.vchdev.contrellers;

import com.vchdev.dao.entity.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @GetMapping("/all")
    public List<Company> findAllCompany(){

        return Collections.emptyList();
    }
}
