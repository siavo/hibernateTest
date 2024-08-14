package com.vchdev.dao.entity;

import com.vchdev.converter.BirthDayConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "username", callSuper = false)
@ToString(exclude = {"company", "userChats"})
@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private UserInfo userInfo;

    @Convert(converter = BirthDayConverter.class)
    @Column(name = "birth_date")
    private BirthDay birthdate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private Profile profile;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserChat> userChats = new ArrayList<>();

}
