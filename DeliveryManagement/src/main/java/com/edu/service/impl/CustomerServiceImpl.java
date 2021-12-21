package com.edu.service.impl;

import com.edu.pojo.Customer;
import com.edu.repository.CustomerRepository;
import com.edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public Customer getCustomerById(int id) {
        return this.customerRepository.getCustomerById(id);
    }

    @Override
    public boolean updateInfo(Customer customer) {
        return this.customerRepository.updateInfo(customer);
    }
    
}
