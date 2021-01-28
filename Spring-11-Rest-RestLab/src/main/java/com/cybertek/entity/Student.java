package com.cybertek.entity;

import com.cybertek.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student extends BaseEntity {

    private LocalDate birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String username;

@OneToOne
@JoinColumn(name = "address_id")
    private Address address;


    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
