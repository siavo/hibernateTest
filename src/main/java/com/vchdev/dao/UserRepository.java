package com.vchdev.dao;

import com.vchdev.dao.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    Optional<User> findUserByUsername(String username);

    boolean existsByUsername(String username);
}
