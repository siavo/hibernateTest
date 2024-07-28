package com.vchdev.services;

import com.vchdev.dao.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {

    List<E> findAll();

    Optional<E> findById(Long id);

    E saveOrUpdate(E entity);

    void delete(Long id);
}
