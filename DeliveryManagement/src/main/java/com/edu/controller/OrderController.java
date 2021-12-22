/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.controller;

import com.edu.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author beanp
 */

@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/auction")
    public String auction(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String keyword = params.getOrDefault("keyword","");

        model.addAttribute("orders", this.orderService.getOrder(keyword, page));
        model.addAttribute("count", this.orderService.countOrder());
        
        return "auction";
    }
}
