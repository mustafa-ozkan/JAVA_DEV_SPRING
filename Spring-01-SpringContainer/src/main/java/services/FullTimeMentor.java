package com.cybertek.services;

import com.cybertek.com.cybertek.interfaces.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccount() {
        System.out.println("Full Time Mentor is created...");
    }
}
