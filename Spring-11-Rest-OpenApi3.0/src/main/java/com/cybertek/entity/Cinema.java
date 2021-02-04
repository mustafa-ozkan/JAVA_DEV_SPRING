package com.cybertek.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity{
//primary key will be created from parent class

    private String name;
    private String sponsoredName;

    //this will create a foreign key for location in cinemas table

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Location location;

    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }
}
