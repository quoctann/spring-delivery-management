package com.edu.repository;

import com.edu.pojo.Customer;


public interface CustomerRepository {
    Customer getCustomerById(int id);
    boolean updateInfo(Customer customer);
}
