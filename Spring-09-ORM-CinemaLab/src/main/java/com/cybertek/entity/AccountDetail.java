package com.cybertek.entity;


import com.cybertek.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
public class AccountDetail extends BaseEntity {


    private String name;
    private String address;
    private Integer age;
    private String country;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "accountDetail")
    private UserAccount userAccount;

    public AccountDetail(String name, String address, Integer age,
                         String country, String city, String state, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.role = role;
    }
}
