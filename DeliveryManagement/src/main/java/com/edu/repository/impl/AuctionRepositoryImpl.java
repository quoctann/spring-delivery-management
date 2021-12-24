package com.edu.repository.impl;

import java.util.List;
import com.edu.pojo.Auction;
import com.edu.repository.AuctionRepository;
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
    public boolean addOrUpdateAuction(Auction auction) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(auction);
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    };

    @Override
    public Auction getAuctionByShipperAndOrder(int shipperId, int orderId) {
        
          Session session = this.sessionFactory.getObject().getCurrentSession();
          CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Auction> query = builder.createQuery(Auction.class);
            Root root = query.from(Auction.class);
            
            Predicate p1 = builder.equal(root.get("shipperId"), shipperId);
            Predicate p2 = builder.equal(root.get("orderId"), orderId);
                      
            query = query.where(builder.and(p1,p2));
            
            Query q = session.createQuery(query);
           
           if (q.getResultList().isEmpty()) {
               return null;
           } else return (Auction) q.getSingleResult();
            
           
    }
}
