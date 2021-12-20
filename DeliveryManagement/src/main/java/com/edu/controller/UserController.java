package com.edu.controller;

import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailService;
    
    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }
    
    @GetMapping("signup")
    public String signUp() {
        return "signup";
    }
    @GetMapping("profile")
    public String profile() {
        return "profile";
    }
}
