package com.cybertek;

import com.cybertek.repository.AccountDetailRepository;
import com.cybertek.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaLabApplication {
    @Autowired
    AccountDetailRepository accountDetailRepository;
    @Autowired
    CinemaRepository cinemaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaLabApplication.class, args);
    }

    @PostConstruct
    public void testAccountDetailsSql(){

    }

    @PostConstruct
    public void testCinemaSql(){

    }

    @PostConstruct
    public void testGenreSql(){

    }

}
