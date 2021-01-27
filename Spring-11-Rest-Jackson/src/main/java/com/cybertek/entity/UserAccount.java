package com.cybertek.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
//hibernateLazyInitializer means whenever there is a fetching type lazy spring adds a field called hibernateLazyInitializer
//if you dont add this we will get an error
public class UserAccount extends  BaseEntity{
//User is a reserved key word in db so you have to change the name of the table
// but you can have the class name as User
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//do not show in the getters but show in setters
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference
    private AccountDetail accountDetail;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
