package com.cybertek.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "useraccounts")
@Getter
@Setter
@NoArgsConstructor
public class UserAccount extends  BaseEntity{

    private String email;
    private String password;
    private String username;

}
