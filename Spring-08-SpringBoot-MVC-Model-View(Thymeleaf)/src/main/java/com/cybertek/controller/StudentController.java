package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Ozzy");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);


        //Create some random studentid (0-1000) and show it on your UI
        int studentID = new Random().nextInt(1000);
        model.addAttribute("studentId", studentID);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i<10;i++
             ) {
            int number= new Random().nextInt(1000);
            numbers.add(number);
        }

        model.addAttribute("numbers", numbers);

        //print your birthday
        LocalDate birthday = LocalDate.now().minusYears(44);
        model.addAttribute("birthday",birthday);



        return "student/welcome";
    }
}
