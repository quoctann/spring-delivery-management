package com.edu.controller;

import com.edu.pojo.Auction;
import com.edu.pojo.Order;
import com.edu.pojo.User;
import com.edu.service.AuctionService;
import com.edu.service.OrderService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuctionController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private AuctionService auctionService;
    
    @GetMapping("/shipper/auction")
    public String auction(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params) {
        User u = (User) session.getAttribute("currentUser");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String keyword = params.getOrDefault("keyword","");
        String sort = params.getOrDefault("sort","sort");
      
        model.addAttribute("auction", new Auction());
        
        model.addAttribute("orders", this.orderService.getOrders(keyword, page, sort, Order.Status.PENDING));
        model.addAttribute("count", this.orderService.countOrder());
        model.addAttribute("shipper_id", u.getId());
        return "auction";
    }
    
    @PostMapping("/shipper/auction")
    public String createAuction(Model model, 
            @ModelAttribute(value = "auction") @Valid Auction auction,
            HttpSession session) {
        model.addAttribute("orders", this.orderService.getOrders("", 1, "", null));
        model.addAttribute("count", this.orderService.countOrder());
        
//        Check Auction đã tồn tại hay chưa ?
        Auction au = this.auctionService.getAuctionByShipperAndOrder(auction.getShipperId().getShipperId(), auction.getOrderId().getId());
      
        if (au != null) {
            auction.setId(au.getId());
        }    
        
//        if (!result.hasErrors()) {            
            if(this.auctionService.addOrUpdateAuction(auction) == true) {
                System.out.println("done");
            };
//        };
        return "auction";
    }
}
