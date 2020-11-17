package com.cybertek.model;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mentor {
    private int id=0;
    private String firstName = "";
    private String lastName = "";
    private Gender gender;
    private int age;

}
