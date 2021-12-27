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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
    
    @Autowired
    private ShipperService shipperService;
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/info")
    public String info(Model model, HttpSession session,
            @RequestParam(name = "page", required = false) String page) {
        
        int pageNum = 1;
        if (page != null) pageNum = Integer.parseInt(page);
        
        User u = (User) session.getAttribute("currentUser");
        Shipper s = this.shipperService.getShipperById(u.getId());
        
        model.addAttribute("idCard", s.getIdCard());
        model.addAttribute("avgRating", s.getAvgRating());
        model.addAttribute("orders", this.orderService.getUserOrders(u.getId(), u.getUserRole(), pageNum));
        
        return "shipperProfile";
    }
    
    // Giống ở trên thôi, làm để reload trang không lỗi
    @GetMapping("/user-info")
    public String userInfo(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        Shipper s = this.shipperService.getShipperById(u.getId());
        model.addAttribute("idCard", s.getIdCard());
        model.addAttribute("avgRating", s.getAvgRating());
        
        return "shipperProfile";
    }
    
    // Chỉ cập nhật các trường của shipper
    @PostMapping("/info")
    public String updateShipperInfo(Model model, HttpSession session,
            @ModelAttribute(value = "shipper") Shipper shipper) {
        
        User u = (User) session.getAttribute("currentUser");
        shipper.setShipperId(u.getId());
        
        if (!this.shipperService.updateInfo(shipper)) {
            model.addAttribute("generalErr", "Cập nhật thông tin shipper thất bại!");
        }
        model.addAttribute("idCard", shipper.getIdCard());
        model.addAttribute("avgRating", shipper.getAvgRating());
        model.addAttribute("successfulUpdate", "Cập nhật thông tin shipper thành công");
        
        return "shipperProfile";
    }
    
    // Chỉ cập nhật các trường của user là shipper (khóa ngoại)
    @PostMapping("/user-info")
    public String updateShipperUserInfo(Model model, HttpSession session,
            @ModelAttribute(value = "user") User user) {
        
        // Lấy những thông tin không được manual update từ dữ liệu form
        User currentUser = (User) session.getAttribute("currentUser");
        User existingUser = this.userDetailsService.getUserById(currentUser.getId());
        user.setPassword(existingUser.getPassword());
        user.setAvatar(existingUser.getAvatar());
        user.setUserRole(existingUser.getUserRole());
        user.setUsername(existingUser.getUsername());
        user.setId(existingUser.getId());
        
        if (!this.userDetailsService.updateInfo(user)) {
            model.addAttribute("generalErr", "Cập nhật thông tin tài khoản thất bại!");
        } else {
            existingUser = this.userDetailsService.getUserById(currentUser.getId());
            session.setAttribute("currentUser", existingUser);
            model.addAttribute("successfulUpdate", "Cập nhật thông tin tài khoản thành công, tải lại trang để hiện thay đổi.");
        }
        
        Shipper shipper = this.shipperService.getShipperById(currentUser.getId());
        model.addAttribute("idCard", shipper.getIdCard());
        model.addAttribute("avgRating", shipper.getAvgRating());
        
        return "shipperProfile";
    }
}
