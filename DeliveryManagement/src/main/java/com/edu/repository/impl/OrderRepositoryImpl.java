package com.edu.repository.impl;

import com.edu.pojo.Customer;
import com.edu.pojo.Order;
import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.repository.OrderRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Order> getOrders(String keyword, int page, String sort, String filterType) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
    
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root root = query.from(Order.class);
        query = query.select(root);
                  
        if (keyword != null) {
            String kw = "%" + keyword + "%";
            Predicate p = builder.like(root.get("description").as(String.class), kw); 
            query = query.where(p);
        }
        
        if (filterType != null) {
            switch(filterType) {
                case Order.Status.PENDING:
                    query = query.where(builder.equal(root.get("status").as(String.class), Order.Status.PENDING));
                    break;
                    
                case Order.Status.SHIPPING:
                    query = query.where(builder.equal(root.get("status").as(String.class), Order.Status.SHIPPING));            
                    break;
                    
                case Order.Status.SUCCESS:
                    query = query.where(builder.equal(root.get("status").as(String.class), Order.Status.SUCCESS));            
                    break;
                
                case Order.Status.FAILED:
                    query = query.where(builder.equal(root.get("status").as(String.class), Order.Status.FAILED));            
                    break;
                    
                default:
                    break;
            }
        }

        if (sort.equals("des")) {
            //System.out.println("in des");
            query = query.orderBy(builder.desc(root.get("id")));
        }
        if (sort.equals("asc")) {
            //System.out.println("in asc");
            query = query.orderBy(builder.asc(root.get("id")));
        }
        
        Query q = session.createQuery(query);
        // Phân trang kết quả trả ra
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    };

    @Override
    public Long countOrder() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("Select COUNT(*) From Order");
         
        return Long.parseLong(query.getSingleResult().toString());
    };

    @Override
    public Order getOrderById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root root = query.from(Order.class);
        
        query = query.where(builder.equal(root.get("id"), id));
        
        Query q = session.createQuery(query);
        
        return (Order) q.getSingleResult();
    }

    @Override
    public Boolean updateOrder(Order order) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.update(order);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
            
        }
    }

    @Override
    public Boolean addOrder(Order order) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(order);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
            
        }
    }

    @Override
    public List<Order> getUserOrders(int userId, String role, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
    
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root rootOrder = query.from(Order.class);
        Root rootCustomer = query.from(Customer.class);
        Root rootShipper = query.from(Shipper.class);
        
        query = query.select(rootOrder);
        
        if (role != null) {
            switch (role) {
                case User.ROLE_CUSTOMER:
                    query = query.where(builder.equal(rootOrder.get("customerId"), rootCustomer.get("customerId")));
                    break;
                    
                case User.ROLE_SHIPPER:
                    query = query.where(builder.equal(rootOrder.get("shipperId"), rootShipper.get("shipperId")));
                    break;
                    
                default:
                    break;
            }
        }
        query = query.orderBy(builder.desc(rootOrder.get("id")));
        query = query.groupBy(rootOrder.get("id"));
        
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Boolean rateOrder(int orderId, int value) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Order order = session.get(Order.class, orderId);
        order.setRateStar(value);
        
        try {
            session.update(order);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

}
