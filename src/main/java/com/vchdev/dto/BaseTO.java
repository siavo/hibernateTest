package com.vchdev.dto;

import com.vchdev.dao.entity.AbstractEntity;
import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.util.EntityConverter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseTO<E extends Serializable> {
    private Long id;

    public BaseEntity convertToEntity(){
        return EntityConverter.convertToEntity(this);
    }
}
