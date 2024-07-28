package com.vchdev.dao;

import com.vchdev.dao.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository <E extends AbstractEntity> extends JpaRepository<E, Long> {
}
