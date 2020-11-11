package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value="/ozzy")
    public String getRequestMappingGet(){
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value="/ozzy")
    public String getRequestMappingPost(){
        return "home";
    }

    @PostMapping("/spring")
    public String postMappingEx(){
        return "home";
    }

    @RequestMapping("/cybertek")
    public String getRequestMapping3(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableExample(@PathVariable("name") String name){

        System.out.println("Name is "+name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableExample(@PathVariable("name") String name, @PathVariable("email") String email){

        System.out.println("Name is "+name);
        System.out.println("email is "+email);

        return "home";
    }

    @GetMapping("/home/course")
    public String requestParamExample(@RequestParam("course") String course){

        System.out.println("Course is "+course);

        return "home";
    }

    @GetMapping(value = "/course")
    public String requestParamExample2(@RequestParam(value= "course", required = false, defaultValue = "Cybertek") String name){

        System.out.println("Course is "+name);

        return "home";
    }

}
