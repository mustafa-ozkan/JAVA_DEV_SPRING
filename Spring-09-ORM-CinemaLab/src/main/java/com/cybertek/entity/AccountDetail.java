package com.cybertek.entity;


import com.cybertek.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
public class AccountDetail extends BaseEntity{


    private String name;
    private String address;
    private String age;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private UserRole role;


}
