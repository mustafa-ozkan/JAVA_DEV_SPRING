package com.cybertek.model;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Map;

//Spring annotations
@Entity
//lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Jackson annotations
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","teacher"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)//temperature is null so we dont want to see it
@Table(name = "address")
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private String city;
    private String country;
//temperature will be taken from API
    //-------------------
    private Integer currentTemperature;

//    private Integer getCurrentTemperature(){
//        return consumeTemp(this.city);
//    }

    public Integer consumeTemp(String city){

        RestTemplate restTemplate = new RestTemplate();

        String BASE_URL = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";

        String uri = BASE_URL+city;

        Object currentWeather = restTemplate.getForObject(uri,Object.class);

        Map<String,Object> getWeather = (Map<String, Object>) currentWeather;

        Map<String,Object> getTemperature =  (Map<String, Object>) getWeather.get("current");


        return Integer.parseInt(getTemperature.get("temperature").toString());
    }
    //---------------------

    @Column(name = "postal_code")
    private String postalCode;
    private String state;
    private String street;

    @OneToOne(mappedBy = "address")//one student one address
    @JsonBackReference//do not show this in the API
    private Student student;

    @OneToOne(mappedBy = "address")//one parent one address
    @JsonIgnore//do not show this in the API-we can use @JsonBackReference
    private Parent parent;

    @OneToOne(mappedBy = "address")//one teacher one address-put ignore to class level
    private Teacher teacher;

    /*
    ways of consuming api
    1. rest template
    2. webclient
     */

}
