package com.cybertek.services;

import com.cybertek.com.cybertek.interfaces.Course;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("weekly teaching hours: 15");
    }
}
