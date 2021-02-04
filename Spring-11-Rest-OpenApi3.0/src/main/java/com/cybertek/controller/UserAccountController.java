package com.cybertek.controller;


import com.cybertek.entity.UserAccount;
import com.cybertek.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/users")
    public List<UserAccount> readAllUsers() {
        return userAccountRepository.findAll();
    }



}
