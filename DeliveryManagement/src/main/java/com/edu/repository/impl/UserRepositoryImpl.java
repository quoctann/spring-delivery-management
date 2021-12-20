package com.edu.repository.impl;

import com.edu.pojo.Customer;
import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        
        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // Bật để thực hiện hai hành động liên tiếp có tính chất cha con
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            switch(user.getUserRole()) {
                case User.ROLE_CUSTOMER:
                    session.save(user);
                    Customer customer = new Customer();
                    customer.setCustomerId(user.getId());
                    session.save(customer);
                    return true;
                    
                case User.ROLE_SHIPPER:
                    session.save(user);
                    Shipper shipper = new Shipper();
                    shipper.setShipperId(user.getId());
                    session.save(shipper);
                    return true;
                    
                default:
                    break;
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
