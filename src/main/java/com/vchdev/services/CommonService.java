package com.vchdev.services;

import com.vchdev.dao.entity.BaseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CommonService<E extends BaseEntity> {

    List<E> findAll();

    Optional<E> findById(Long id);

    Optional<E> saveOrUpdate(E obj);

    void delete(Long id);
}
