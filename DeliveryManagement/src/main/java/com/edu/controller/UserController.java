package com.edu.controller;

import com.edu.pojo.User;
import com.edu.service.UserService;
import com.edu.validator.WebAppValidator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private WebAppValidator userValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    // View của trang đăng nhập
    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }
    
    // View của trang đăng ký
    @GetMapping("signup")
    public String signUpView() {
        return "signup";
    }

    @GetMapping("profile")
    public String profile() {
        return "profile";
    }
      // Xử lý post request tạo tài khoản (đăng ký)
    @PostMapping("signup")
    public String signUp(Model model, 
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        
        if (!result.hasErrors()) {
            if (user.getPassword().isEmpty() || 
                !user.getPassword().equals(user.getConfirmPassword())) {
                model.addAttribute("passwordNotMatch", "Nhap lai mat khau khong dung!");
            } 
            
            
            else {
                
                List<User> checkUsername = this.userDetailsService.getUsers(user.getUsername());
                
                if (!checkUsername.isEmpty()) {
                    model.addAttribute("usernameAlreadyExists", "Tai khoan da ton tai trong he thong");
                } else {
                    if (this.userDetailsService.addUser(user)) {
                        return "redirect:/signin";
                    }
                }
            }
        }
        
        return "signup";
    }
}
