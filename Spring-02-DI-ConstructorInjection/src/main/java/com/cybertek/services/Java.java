package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {
    OfficeHours officeHours = new OfficeHours();

    public Java(OfficeHours officeHours) {
        this.officeHours= officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("weekly teaching hours:"+(20+officeHours.getHours()));
    }

}
