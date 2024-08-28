package com.vchdev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTO extends BaseTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String role;
    private LocalDate registrationDate;
}
