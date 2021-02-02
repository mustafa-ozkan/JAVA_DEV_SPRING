package com.cybertek.model;

import com.cybertek.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
@Table(name = "parent")
public class Parent extends BaseEntity {

    private LocalDate birthday;
    private String email;
    private String firstName;
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String phoneNumber;

    private String profession;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String username;

    @OneToOne(cascade = CascadeType.ALL)//error can occur so we might change this
    @JoinColumn(name = "address_id")
    private Address address;

}
