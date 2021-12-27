package com.edu.repository;

import com.edu.pojo.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrders(String keyword, int page, String sort, String filterType);
    List<Order> getUserOrders(int userId, String role, int page);
    Order getOrderById(int id);
    Long countOrder();
    Boolean updateOrder(Order order);
    Boolean addOrder(Order order);
    Boolean rateOrder(int orderId, int value);
    Boolean updateStatus(int orderId, String status);
}
