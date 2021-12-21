package com.edu.service;

import com.edu.pojo.Customer;


public interface CustomerService {
    Customer getCustomerById(int id);
    boolean updateInfo(Customer customer);
    
}
