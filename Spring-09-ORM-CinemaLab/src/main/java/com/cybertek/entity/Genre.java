package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre extends BaseEntity {

    private String name;


    //do we need below manytomay ?
    // we do not but best practice to have it
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList=new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }
}
