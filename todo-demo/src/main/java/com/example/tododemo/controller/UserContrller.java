package com.example.tododemo.controller;

import com.example.tododemo.entity.User;
import com.example.tododemo.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContrller {
    @Autowired
    JWTService jwtService;
    @PostMapping("/login")
    public String login(User user){
        if(user.getUsername().equals("admin") && user.getPassword().equals("a123")){
            return jwtService.generateToken(user.getUsername());
        }
        return "login failed";
    }
}
