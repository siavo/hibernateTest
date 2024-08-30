package com.vchdev.dto;

import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.dao.entity.BirthDay;
import com.vchdev.dao.entity.User;
import com.vchdev.dao.entity.UserInfo;
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

    @Override
    public User convertToEntity() {
        User user = (User)super.convertToEntity();
        user.setUserInfo(new UserInfo(firstname, lastname));
        user.setBirthdate(new BirthDay(birthdate));
        return user;
    }
}
