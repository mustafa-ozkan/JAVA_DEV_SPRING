package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    private String street;
    private String zipCode;

    @ManyToOne
    private Person person;
}
