package com.edu.service;

import com.edu.pojo.Order;
import java.util.List;

public interface OrderService {
    List<Order> getOrders(String keyword, int page, String sort, String filterType);
    List<Order> getUserOrders(int userId, String role, int page);
    Long countOrder();
    Order getOrderById(int id);
    Boolean updateOrder(Order order) ;
    Boolean addOrder(Order order);
    Boolean rateOrder(int orderId, int value);
}
