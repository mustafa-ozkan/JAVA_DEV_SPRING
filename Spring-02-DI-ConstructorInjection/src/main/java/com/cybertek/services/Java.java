package com.cybertek.services;

import com.cybertek.com.cybertek.interfaces.Course;
import com.cybertek.com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    ExtraSessions extraSessions;

    public Java(OfficeHours officeHours) {
        this.extraSessions= officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("weekly teaching hours:"+(20+extraSessions.getHours()));
    }

}
