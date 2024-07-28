package com.vchdev.services;

import com.vchdev.dao.UserRepository;
import com.vchdev.dao.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
