package com.cybertek.model;

import com.cybertek.enums.EducationLevel;
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
@Table(name = "teacher")
public class Teacher extends BaseEntity{


    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level")
    private EducationLevel educationLevel;
    private String email;
    private String firstName;
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String username;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
