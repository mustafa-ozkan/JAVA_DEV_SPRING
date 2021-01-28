package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer"}, ignoreUnknown = true)
public class Genre extends BaseEntity {

    private String name;


    //do we need below manytomay ?
    // we do not but best practice to have it
    @ManyToMany(mappedBy = "genreList")
    @JsonIgnore
    private List<Movie> movieList=new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }
}
