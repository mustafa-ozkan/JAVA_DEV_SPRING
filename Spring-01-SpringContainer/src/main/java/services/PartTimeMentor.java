package com.cybertek.services;

import com.cybertek.com.cybertek.interfaces.Mentor;

public class PartTimeMentor implements Mentor {

    @Override
    public void createAccount() {
        System.out.println("Part Time Mentor is created...");
    }
}
