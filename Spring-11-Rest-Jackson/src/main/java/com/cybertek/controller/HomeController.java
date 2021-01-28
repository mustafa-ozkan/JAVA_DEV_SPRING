package com.cybertek.controller;

import com.cybertek.entity.AccountDetail;
import com.cybertek.entity.UserAccount;
import com.cybertek.repository.AccountDetailRepository;
import com.cybertek.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    UserAccountRepository userAccountRepository;
    AccountDetailRepository accountDetailRepository;

    public HomeController(UserAccountRepository userAccountRepository, AccountDetailRepository accountDetailRepository) {
        this.userAccountRepository = userAccountRepository;
        this.accountDetailRepository = accountDetailRepository;
    }

    @GetMapping("/users")
    public List<UserAccount> readAllUsers() {
        return userAccountRepository.findAll();
    }


    @GetMapping("/accounts")
    public List<AccountDetail> readAllAccountDetails() {
        return accountDetailRepository.findAll();
    }
}
