package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @GetMapping("/info")
    public String info() {
        return "customerProfile";
    }
    
    @PostMapping("/info")
    public String updateCustomerInfo(Model model) {
        return "customerProfile";
    }
}
