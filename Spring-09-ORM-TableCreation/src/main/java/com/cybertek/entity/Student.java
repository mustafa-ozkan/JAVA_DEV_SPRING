package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;//first_name in the database by hybernate
    private String lastName;
    private String email;

}
