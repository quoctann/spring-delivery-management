package com.edu.controller;

import com.edu.pojo.Customer;
import com.edu.pojo.User;
import com.edu.service.CustomerService;
import com.edu.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/info")
    public String info(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        Customer c = this.customerService.getCustomerById(u.getId());
        model.addAttribute("address", c.getAddress());
        
        return "customerProfile";
    }
    
    // Giống ở trên thôi, làm để reload trang không lỗi
    @GetMapping("/user-info")
    public String userInfo(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        Customer c = this.customerService.getCustomerById(u.getId());
        model.addAttribute("address", c.getAddress());
        
        return "customerProfile";
    }
    
    // Chỉ cập nhật thông tin trong bảng customer
    @PostMapping("/info")
    public String updateCustomerInfo(Model model, HttpSession session,
            @ModelAttribute(value = "customer") Customer customer) {
        
        User u = (User) session.getAttribute("currentUser");
        customer.setCustomerId(u.getId());
        
        if (!this.customerService.updateInfo(customer)) {
            model.addAttribute("generalErr", "Cập nhật thông tin khách hàng thất bại!");
        }
        model.addAttribute("address", customer.getAddress());
        model.addAttribute("successfulUpdate", "Cập nhật thông tin khách hàng thành công");
        
        return "customerProfile";
    }
    
    // Chỉ cập nhật thông tin trong bảng user (khóa ngoại đến customer)
    @PostMapping("/user-info")
    public String updateCustomerUserInfo(Model model, HttpSession session,
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
        
        Customer customer = this.customerService.getCustomerById(currentUser.getId());
        model.addAttribute("address", customer.getAddress());
        
        return "customerProfile";
    }
}
