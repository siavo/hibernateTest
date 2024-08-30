package com.vchdev.dao.entity;

import com.vchdev.converter.BirthDayConverter;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.UserTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "username", callSuper = false)
@ToString(exclude = {"company", "userChats"})
@Entity
@Table(name = "users")
@DynamicInsert
public class User extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private UserInfo userInfo;

    @Convert(converter = BirthDayConverter.class)
    @Column(name = "birth_date")
    private BirthDay birthdate;

    @Column(name = "role")
    @ColumnDefault("'NOBODY'")
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

    private LocalDate registrationDate;

    @Override
    public UserTO convertToDTO() {

        UserTO userTO = (UserTO) super.convertToDTO();

        userTO.setBirthdate(this.getBirthdate() != null ? this.getBirthdate().birthDate() : null);
        userTO.setRole(this.getRole().name());
        userTO.setFirstname(this.getUserInfo() != null ? this.getUserInfo().getFirstname() : null);
        userTO.setLastname(this.getUserInfo() != null ? this.getUserInfo().getLastname() : null);

        return userTO;
    }
}
