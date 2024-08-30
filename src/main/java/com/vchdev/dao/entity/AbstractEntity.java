package com.vchdev.dao.entity;

import com.vchdev.dto.BaseTO;
import com.vchdev.util.EntityConverter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements BaseEntity<T>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

     public BaseTO convertToDTO(){
        return EntityConverter.convertToDto(this);
    }
}
