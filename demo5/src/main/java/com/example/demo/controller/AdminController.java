package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/test1")
    public String test1(){
        return "admin-endpoint-test1,需admin权限";
    }
    @GetMapping("/test2")
    public String test2(){
        return "admin-endpoint-test2,需admin权限";
    }
}
