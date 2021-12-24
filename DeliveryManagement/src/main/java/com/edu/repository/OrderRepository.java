package com.edu.repository;

import com.edu.pojo.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrders(String keyword, int page, String sort, String filterType);
    Long countOrder();
}
