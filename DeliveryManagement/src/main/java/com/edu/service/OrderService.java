/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.service;

import com.edu.pojo.Order;
import java.util.List;

/**
 *
 * @author beanp
 */
public interface OrderService {
    List<Order> getOrder(String keyword, int page);
    Long countOrder();
}
