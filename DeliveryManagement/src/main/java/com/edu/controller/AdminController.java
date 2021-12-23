package com.edu.controller;

import com.edu.pojo.Shipper;
import com.edu.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ShipperService shipperService;
    
    // Trả về view cho người dùng
    
    @GetMapping("")
    public String info() {
        return "admin";
    }
        
    @GetMapping("/shipper")
    public String shipperManangement(Model model) {
        List<Object[]> spList = this.shipperService.getShipperList(null, null, 1);

        model.addAttribute("shipperList", spList);
        
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
    
    // Xử lý các request CRUD
}
