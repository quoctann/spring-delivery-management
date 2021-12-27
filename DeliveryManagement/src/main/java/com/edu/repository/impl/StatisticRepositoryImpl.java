package com.edu.repository.impl;

import com.edu.pojo.Order;
import com.edu.repository.StatisticRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> incomeStatistic(Date fromDate, Date toDate, String type) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootOrder = query.from(Order.class);
        List<Predicate> pre = new ArrayList<>();
        
        pre.add(builder.equal(rootOrder.get("status"), Order.Status.SUCCESS));
        
        if (type != null) {
            pre.add(builder.equal(rootOrder.get("type"), type));
        }
        
        if (fromDate != null) {
            pre.add(builder.greaterThanOrEqualTo(rootOrder.get("createdDate"), fromDate));
        }
        
        if (toDate != null) {
            pre.add(builder.lessThanOrEqualTo(rootOrder.get("createdDate"), toDate));
        }
        
        query.where(pre.toArray(new Predicate[] {}));
        query.multiselect(
                builder.function("DAY", Integer.class, rootOrder.get("createdDate")),
                builder.function("MONTH", Integer.class, rootOrder.get("createdDate")),
                builder.function("YEAR", Integer.class, rootOrder.get("createdDate")),
                builder.count(rootOrder.get("id")),
                builder.sum(rootOrder.get("price"))
        );
        query.groupBy(rootOrder.get("createdDate"));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
