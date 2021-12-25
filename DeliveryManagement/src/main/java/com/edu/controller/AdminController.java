package com.edu.controller;

import com.edu.pojo.Order;
import com.edu.pojo.Shipper;
import com.edu.service.OrderService;
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
    
    @Autowired
    private OrderService orderService;
    
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
        if (page != null) { pageNum = Integer.parseInt(page); } else { pageNum = 1; }
        
        List<Object[]> spList = this.shipperService.getShipperList(filterType, username, pageNum);

        model.addAttribute("shipperList", spList);
        model.addAttribute("filterType", filterType);
        model.addAttribute("shipperCount", this.shipperService.countShipper());
        
        return "shipperManagement";
    }
    
    @GetMapping("/order")
    public String orderManagement(Model model,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "filterType", required = false) String filterType,
            @RequestParam(name = "sort", required = false) String sort) {
        
        int pageNum = 1;
        
        if (page != null) pageNum = Integer.parseInt(page);
        
        List<Order> orderList = this.orderService.getOrders(description, pageNum, sort, filterType);
        
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderCount", this.orderService.countOrder());
        
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
    
    // Update một phần thông tin của shipper
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
