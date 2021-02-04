package com.cybertek.controller;

import com.cybertek.entity.Cinema;
import com.cybertek.repository.CinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    CinemaRepository cinemaRepository;


    @GetMapping("/users")
    public List<Cinema> readAllUsers() {
        return cinemaRepository.findAll();
    }
}
