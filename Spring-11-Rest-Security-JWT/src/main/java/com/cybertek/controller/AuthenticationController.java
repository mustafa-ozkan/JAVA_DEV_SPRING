package com.cybertek.controller;

import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.service.UserService;
import com.cybertek.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest){

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        //gimme the user
        User foundUser = userService.readByUsername(username);

        //to use in authentication manager we create a new authenticationtoken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);

   //it has been authenticated using below line
        authenticationManager.authenticate(authenticationToken);
        //now i will create the token for you from JWT

        String jwtToken = jwtUtil.generateToken(foundUser);

        return ResponseEntity.ok(new ResponseWrapper("Login Successful!",jwtToken));

    }

}
