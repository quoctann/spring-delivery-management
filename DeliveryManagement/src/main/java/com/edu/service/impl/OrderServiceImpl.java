package com.edu.service.impl;

import com.edu.pojo.Order;
import com.edu.repository.OrderRepository;
import com.edu.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    
    @Override
    public List<Order> getOrders(String keyword, int page, String sort, String filterType) {        
        if (sort == null) sort = "des";
        if (filterType == null) filterType = "ALL";
        if (keyword == null || keyword.isBlank() || keyword.isEmpty()) keyword = null;
        
        return this.orderRepository.getOrders(keyword, page, sort, filterType);
    }

    @Override
    public Long countOrder() {
        return this.orderRepository.countOrder();
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderRepository.getOrderById(id);
    }

    @Override
    public Boolean updateOrder(Order order) {
        return this.orderRepository.updateOrder(order);
    }

    @Override
    public Boolean addOrder(Order order) {
        return this.orderRepository.addOrder(order);
    }

    @Override
    public List<Order> getUserOrders(int userId, String role, int page) {
        return this.orderRepository.getUserOrders(userId, role, page);
    }

    @Override
    public Boolean rateOrder(int orderId, int value) {
        return this.orderRepository.rateOrder(orderId, value);
    }
    
}
