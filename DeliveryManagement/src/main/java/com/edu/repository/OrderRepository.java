/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.repository;

/**
 *
 * @author beanp
 */
import com.edu.pojo.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrders(String keyword, int page);
    Long countOrder();
}
