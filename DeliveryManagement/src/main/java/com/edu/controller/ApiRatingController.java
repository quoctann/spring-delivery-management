package com.edu.controller;

import com.edu.pojo.User;
import com.edu.service.OrderService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRatingController {
    
    @Autowired
    private OrderService orderService;
    
    @PutMapping("rate-order/{id}")
    public HttpStatus rateOrder(@RequestParam(name = "value", required=true) String value,
            @PathVariable(value = "id") String orderId) {
        
        if (this.orderService.rateOrder(Integer.parseInt(orderId), Integer.parseInt(value)))
            return HttpStatus.OK;
        
        return HttpStatus.BAD_REQUEST;
    }
//    
//    @PutMapping("order-status/{id}")
//    public HttpStatus updateStatust(@RequestParam(name = "status", required=true) String status,
//            @PathVariable(value = "id") String orderId) {
//        
//        if (this.orderService.updateStatus(Integer.parseInt(orderId), status))
//            return HttpStatus.OK;
//        
//        return HttpStatus.BAD_REQUEST;
//    }
}
