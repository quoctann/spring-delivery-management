/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.service.impl;

import com.edu.pojo.Order;
import com.edu.repository.OrderRepository;
import com.edu.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author beanp
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    
    @Override
    public List<Order> getOrder(String keyword, int page, String sort) {
        return this.orderRepository.getOrders(keyword, page, sort);
    }

    @Override
    public Long countOrder() {
        return this.orderRepository.countOrder();
    }
    
}
