package com.edu.repository;

import com.edu.pojo.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrders(String keyword, int page, String sort, String filterType);
    Order getOrderById(int id);
    Long countOrder();
    Boolean updateOrder(Order order);
    Boolean addOrder(Order order);
}
