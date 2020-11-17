package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @GetMapping("/mentor-list")
    public String showTable(Model model){
        List<Mentor> mentorList= new ArrayList<>();
        mentorList.add(new Mentor(1,"Mike","Smith", Gender.MALE,45));
        mentorList.add(new Mentor(2,"Tom","Hanks", Gender.MALE,35));
        mentorList.add(new Mentor(3,"Mash","Room", Gender.FEMALE,55));

        model.addAttribute("mentors", mentorList);

        return "mentor/mentor-list";



    }
}
