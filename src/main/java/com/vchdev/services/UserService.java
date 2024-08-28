package com.vchdev.services;

import com.vchdev.dao.UserRepository;
import com.vchdev.dao.entity.User;
import com.vchdev.security.SecurityUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractService<User, UserRepository> implements UserDetailsService{
    public UserService(UserRepository repository) {
        super(repository);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findUserByUsername(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return new SecurityUserDetails(user.get());
    }

    public boolean existByUsername(String username){
        return repository.existsByUsername(username);
    }
}
