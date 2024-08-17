package com.vchdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class MainHibernateRunner {

    public static void main(String[] args) {


        SpringApplication.run(MainHibernateRunner.class, args);
        //SecurityContextHolder.clearContext();
    }

}
