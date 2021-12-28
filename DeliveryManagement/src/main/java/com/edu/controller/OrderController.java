package com.edu.controller;

import com.edu.pojo.Auction;
import com.edu.pojo.Order;
import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.service.AuctionService;
import com.edu.service.CustomerService;
import com.edu.service.OrderService;
import com.edu.service.ShipperService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private AuctionService auctionService;
    
    @Autowired
    private ShipperService shipperService;
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/orderDetail/{id}")
    public String orderDetailView(Model model, @PathVariable int id, HttpSession session) {
        List<Auction> aus = this.auctionService.getAuctionsByOrderId(id);
        
        List<Shipper> shippers = new ArrayList<Shipper>();
        
        for (Auction a : aus) {
            shippers.add(this.shipperService.getShipperById(a.getShipperId().getShipperId()));
        }
        
        model.addAttribute("order", this.orderService.getOrderById(id));
        model.addAttribute("shippers", shippers);
        
        User current = (User) session.getAttribute("currentUser");
        if (current.getUserRole().equals(User.ROLE_SHIPPER))
            return "shipperOrderDetail";
        
        return "orderDetail";
    }; 
    
    @PostMapping("/orderDetail/{id}")
    public String updateOrder(Model model, @PathVariable int id, @ModelAttribute(value = "order") @Valid Order order, HttpSession session) {
        
        User current = (User) session.getAttribute("currentUser");      
        
            order.setStatus("SHIPPING");
            order.setCreatedDate(this.orderService.getOrderById(id).getCreatedDate());
        
        if (this.orderService.updateOrder(order) == true) {
            System.out.println("Thanh cong");
        }
                      
        model.addAttribute("order", order);
        
        if (current.getUserRole().equals(User.ROLE_SHIPPER))
            return "shipperOrderDetail";
        
        return "redirect:/orderDetail/"+ id ;
    }
    
    @GetMapping("/createOrder")
    public String createOrderView(Model model) {
        model.addAttribute("order", new Order());
        
        return "createOrder";
    }; 
    
     @PostMapping("/createOrder")
    public String createOrderView(Model model, HttpSession session, @ModelAttribute(value = "order") @Valid Order order) {
        User u = (User) session.getAttribute("currentUser");
        order.setCustomerId(this.customerService.getCustomerById(u.getId()));

       
        order.setStatus(Order.Status.PENDING);
        order.setPaymentMethod("CASH");
        order.setCreatedDate(new Date());
        
         if (this.orderService.addOrder(order) == true) {      
            return "redirect:/customer/info";
        } else return "404";                 
    }; 
    
}
