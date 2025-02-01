package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    @GetMapping("/test1")
    public String test1(){
        return "普通endpoint-test1,无需权限";
    }
    @GetMapping("/test2")
    public String test2(){
        return "普通endpoint-test2,无需权限";
    }
}
