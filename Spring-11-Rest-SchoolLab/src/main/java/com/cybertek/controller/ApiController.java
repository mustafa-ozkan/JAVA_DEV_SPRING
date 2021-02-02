package com.cybertek.controller;


import com.cybertek.model.ResponseWrapper;
import com.cybertek.model.Teacher;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    /*
        Address get, create , update, delete

     */

    //inject repository
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }
    /*creating APIs 3 ways
    1. legacy way(it is old way
    2. restcontroller
    3. responseentity(they need to know who we are )
     */

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {

        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));

    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readALlParents() {

        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved", HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);

    }


}
