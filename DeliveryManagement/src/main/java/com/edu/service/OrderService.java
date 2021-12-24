package com.edu.service;

import com.edu.pojo.Order;
import java.util.List;

public interface OrderService {
    List<Order> getOrders(String keyword, int page, String sort, String filterType);
    Long countOrder();
}
