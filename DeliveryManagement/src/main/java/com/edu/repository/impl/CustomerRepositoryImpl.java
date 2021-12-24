package com.edu.repository.impl;

import com.edu.pojo.Customer;
import com.edu.pojo.User;
import com.edu.repository.CustomerRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public boolean updateInfo(Customer customer) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.update(customer);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

}
