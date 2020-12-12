package com.cybertek.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name = "studentFirstName")
    private String firstName;//first_name in the database by hybernate
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddress")
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;
    @Column(columnDefinition = "TIME")
    private LocalDate localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate localDateTime;



}
