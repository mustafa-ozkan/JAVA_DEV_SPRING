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
@Table(name = "student")
public class Student extends BaseEntity {

    private LocalDate birthday;

    private String email;
    private String firstName;
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String username;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//try lazy fetch
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY)//many student can have one parent
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
