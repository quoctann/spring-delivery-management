/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.formatter;

import com.edu.pojo.Customer;
import com.edu.pojo.Shipper;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author beanp
 */
public class CustomerFormatter implements Formatter<Customer> {
    
     @Override
    public String print(Customer c, Locale locale) {
        return String.valueOf(c.getCustomerId());
    }

    @Override
    public Customer parse(String Id, Locale locale) throws ParseException {
        Customer c = new Customer();
        c.setCustomerId(Integer.parseInt(Id));
        
        return c;
    }
    
}
