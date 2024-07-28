package com.vchdev.services;

import com.vchdev.dao.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends JpaRepository> implements CommonService<E>{

    protected final R repository;

    @Autowired
    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public E saveOrUpdate(E entity){
        return (E) repository.save(entity);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

}
