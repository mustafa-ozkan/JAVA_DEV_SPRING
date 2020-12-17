package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="person_id")
//    private List<Address> addresses;

}
