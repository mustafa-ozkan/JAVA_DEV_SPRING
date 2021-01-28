package com.cybertek.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer"}, ignoreUnknown = true)
public class Location extends BaseEntity {


    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;

    public Location(String name, BigDecimal latitude, BigDecimal longitude, String postalCode, String country,
                    String city, String state, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}
