package com.vchdev.dao;

import com.vchdev.dao.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CommonRepository<Profile> {
}
