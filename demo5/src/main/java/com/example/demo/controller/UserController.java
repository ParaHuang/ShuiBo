package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/test1")
    public String test1(){
        return "user-endpoint-test1,需user权限";
    }
    @GetMapping("/test2")
    public String test2(){
        return "user-endpoint-test2,需user权限";
    }
}
