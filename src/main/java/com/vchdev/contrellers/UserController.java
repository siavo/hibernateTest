package com.vchdev.contrellers;

import com.vchdev.dao.entity.User;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.UserTO;
import com.vchdev.services.UserService;
import com.vchdev.util.EntityConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    public final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List> findAll() {
        List<BaseTO> users = new ArrayList<>();
        try{
            users = EntityConverter.convertToDTOs(service.findAll());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.noContent().build();
        } return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public ResponseEntity<UserTO> add(@RequestBody UserTO userTO){
        try{
            userTO = (UserTO) EntityConverter.convertToDto(service.saveOrUpdate((User) EntityConverter.convertToEntity(userTO)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } return new ResponseEntity<>(userTO, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UserTO userTO){

        service.saveOrUpdate((User) EntityConverter.convertToEntity(userTO));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            service.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity("Can not delete company id:" + id, HttpStatus.NOT_ACCEPTABLE);
        } return ResponseEntity.noContent().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<UserTO> findById(@PathVariable Long id){
        UserTO userTO = null;
        try {
            userTO = (UserTO) EntityConverter.convertToDto(service.findById(id).get());
        } catch (Exception e) {
            log.error(e.getMessage());
            new ResponseEntity("User id:" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(userTO);
    }
}
