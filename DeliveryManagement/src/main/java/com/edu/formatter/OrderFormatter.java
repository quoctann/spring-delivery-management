/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.formatter;

import com.edu.pojo.Order;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author beanp
 */
public class OrderFormatter implements Formatter<Order> {
    

    @Override
    public String print(Order o, Locale locale) {
        return String.valueOf(o.getId());
    }

    @Override
    public Order parse(String Id, Locale locale) throws ParseException {
        Order o = new Order();
        o.setId(Integer.parseInt(Id));
        
        return o;
    }
    
    
}
