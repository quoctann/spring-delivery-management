// Testing workable project
package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ControllerAdvice để đính kèm thông tin lên tất cả model
@Controller
public class TestController {
    
//    @Autowired
//    private LocalSessionFactoryBean sessionFactory;
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
