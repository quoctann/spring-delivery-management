/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.controller;

import com.edu.pojo.Auction;
import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.service.AuctionService;
import com.edu.service.OrderService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author beanp
 */
@Controller
public class AuctionController {
    
    @Autowired
    private OrderService orderService;
    
//    @Autowired
//    private AuctionService auctionService;
    
    @GetMapping("/auction")
    public String auction(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String keyword = params.getOrDefault("keyword","");
        String sort = params.getOrDefault("sort","sort");
      
        model.addAttribute("orders", this.orderService.getOrder(keyword, page, sort));
        model.addAttribute("count", this.orderService.countOrder());
        
        return "auction";
    }
    
    @PostMapping("/auction")
    public String createAuction(Model model, 
            @ModelAttribute(value = "auction") @Valid Auction auction,
            HttpSession session,
            BindingResult result) {
        if (!result.hasErrors()) {
            User u = (User) session.getAttribute("currentUser");
        }
        return "auction";
    }
}
