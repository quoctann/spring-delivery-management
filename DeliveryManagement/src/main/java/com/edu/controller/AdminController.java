package com.edu.controller;

import com.edu.pojo.Shipper;
import com.edu.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String shipperManangement(Model model, 
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "filterType", required = false) String filterType) {
        
        int pageNum;
        if (page != null) {
            pageNum = Integer.parseInt(page); 
        } else {
            pageNum = 1;
        }  
        List<Object[]> spList = this.shipperService.getShipperList(filterType, username, pageNum);

        model.addAttribute("shipperList", spList);
        model.addAttribute("filterType", filterType);
        
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
    @PostMapping("/shipper")
    public String partialUpdateShipperInfo(Model model,
            @RequestParam(name = "id") int id,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "idCard") String idCard) {
        
        if (this.shipperService.partialUpdateByAdmin(id, email, phone, idCard)) {
            model.addAttribute("updateSuccess", "Cập nhật thành công!");
        } else {
            model.addAttribute("updateFailed", "Cập nhật thất bại!");
        }
        
        List<Object[]> spList = this.shipperService.getShipperList("all", null, 1);
        model.addAttribute("shipperList", spList);
        
        return "shipperManagement";
    }
}
