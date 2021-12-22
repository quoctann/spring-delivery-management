/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.repository.impl;

import java.util.List;
import com.edu.pojo.Auction;
import com.edu.repository.AuctionRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author beanp
 */
@Repository
@Transactional
public class AuctionRepositoryImpl implements AuctionRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Auction getAuctionById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Auction.class, id);
    };
    
    @Override
    public List<Auction> getAuctions() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("From Auction");
        return query.getResultList();
    };
    
    @Override
    public boolean addAuction(Auction auction) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(auction);
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    };
}
