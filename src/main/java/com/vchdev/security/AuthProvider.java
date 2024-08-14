package com.vchdev.security;

import com.vchdev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProvider implements AuthenticationProvider {

    private final UserService service;

    @Autowired
    public AuthProvider(UserService service) {
        this.service = service;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails user = service.loadUserByUsername(authentication.getName());
        String password = authentication.getCredentials().toString();
        if (!password.equals(user.getPassword())){
            throw new BadCredentialsException("Bad Credentials for user: " + user.getUsername());
        }
        return new UsernamePasswordAuthenticationToken(user, password, Collections.EMPTY_LIST);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
