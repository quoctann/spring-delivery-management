// Testing workable project
package com.edu.controller;

import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.service.OrderService;
import com.edu.service.ShipperService;
import com.edu.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ControllerAdvice để đính kèm thông tin lên tất cả model
@Controller
@ControllerAdvice
public class GeneralController {
    
    @Autowired
    private ShipperService shipperService;
    
    @Autowired
    private UserService userDetailsService;
     
    @ModelAttribute
    public void generalAttributes(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    // Endpoint để xem trang chi tiết một shipper + bình luận (đối với user đã đăng nhập -> sd rest api)
    @GetMapping("/shipper-detail/{id}")
    public String shipperDetail(@PathVariable(value = "id") int shipperId, Model model,
            HttpSession session) {
        
        // Nếu user chưa đăng nhập thì không được xem trang này (chặn request bằng controller)
        User signedUser = (User) session.getAttribute("currentUser");
        if (signedUser == null) {
            return "403";
        }
        
        Shipper shipper = this.shipperService.getShipperById(shipperId);
        User userIsShipper = this.userDetailsService.getUserById(shipperId);
        
        model.addAttribute("userAsShipperInfo", userIsShipper);
        model.addAttribute("shipperInfo", shipper);
        return "shipperDetail";
    }
}  
