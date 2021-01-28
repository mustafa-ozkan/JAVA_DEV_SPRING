package com.cybertek.entity;


import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = {"state","postal_code","hibernate_lazy_initializer"}, ignoreUnknown = true)
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
    @JsonBackReference//when we dont want to see user
    //if we use @Jsonignore we kind of lose the relation awareness
    private UserAccount userAccount;

    public AccountDetail(String name, String address, String country,
                         String state,String city, Integer age, String postalCode, UserRole role) {
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
