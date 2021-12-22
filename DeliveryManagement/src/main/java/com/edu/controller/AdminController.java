package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("")
    public String info() {
        return "admin";
    }
    
    @GetMapping("/shipper")
    public String shipperManangement() {
        return "shipperManagement";
    }
    
    @GetMapping("/order")
    public String orderManagement() {
        return "orderManagement";
    }
    
    @GetMapping("/income-stat")
    public String incomeStat() {
        return "incomeStat";
    }
    
    @GetMapping("/frequency-stat")
    public String frequencyStat() {
        return "frequencyStat";
    }
}
