package com.vchdev.security;

import com.vchdev.dao.entity.User;
import com.vchdev.dto.UserTO;
import com.vchdev.security.request.LoginRequest;
import com.vchdev.security.response.JwtResponse;
import com.vchdev.services.UserService;
import com.vchdev.util.EntityConverter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Base64;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getUser().getRole().name()));
    }

    @PostMapping("sign_up")
    public ResponseEntity singUp(@RequestBody LoginRequest userTO) {
        UserTO newUserTO;
        if (userService.existByUsername(userTO.getUsername())) {
            return new ResponseEntity("User with name " + userTO.getUsername() + " already exist", HttpStatus.BAD_REQUEST);
        }
        User user = User.builder().build();
        user.setUsername(userTO.getUsername());
        user.setPassword(userTO.getPassword());

        user = userService.saveOrUpdate((User) user);

        newUserTO = (UserTO) EntityConverter.convertToDto(user);

        return new ResponseEntity(newUserTO, HttpStatus.CREATED);
    }
}