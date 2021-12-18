// Testing workable project
package com.edu.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// ControllerAdvice để đính kèm thông tin lên tất cả model
@Controller
@ControllerAdvice
public class GeneralController {
    
    @ModelAttribute
    public void generalAttributes(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
