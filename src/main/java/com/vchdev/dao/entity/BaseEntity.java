package com.vchdev.dao.entity;

import com.vchdev.dto.BaseTO;

public interface BaseEntity<T> {
    T getId();

    BaseTO convertToDTO();
}
