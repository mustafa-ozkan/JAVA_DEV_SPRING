package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {
    ExtraSessions extraSessions = new OfficeHours();

    @Override
    public void getTeachingHours() {
        System.out.println("weekly teaching hours:"+(20+extraSessions.getHours()));
    }

}
