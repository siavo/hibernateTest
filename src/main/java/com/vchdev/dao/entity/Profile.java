package com.vchdev.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "user")
@Entity
public class Profile extends BaseEntity<Long>{

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private String street;
    private String language;

    public void setUser(User user){
        user.setProfile(this);
        this.user = user;
    }
}
