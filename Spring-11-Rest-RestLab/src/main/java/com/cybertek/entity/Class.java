package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Setter
@Getter

public class Class extends BaseEntity {

    private String name;
    private Integer year;


    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}
