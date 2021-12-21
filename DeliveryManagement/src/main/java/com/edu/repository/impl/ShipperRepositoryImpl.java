package com.edu.repository.impl;

import com.edu.pojo.Shipper;
import com.edu.repository.ShipperRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShipperRepositoryImpl implements ShipperRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Shipper getShipperById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Shipper.class, id);
    }

    @Override
    public boolean updateInfo(Shipper shipper) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.update(shipper);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
