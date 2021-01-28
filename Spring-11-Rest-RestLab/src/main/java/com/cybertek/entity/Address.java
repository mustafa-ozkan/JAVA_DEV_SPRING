package com.cybertek.entity;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "address")
public class Address extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String city;
    private String country;


    private Integer currentTemperature;

    private Integer currentTemperature(){
        return consumeTemp(this.city);
    }

    public Integer consumeTemp(String city){
        return 5;
    }

    @Column(name = "postal_code")
    private String postalCode;
    private String state;
    private String street;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

}
