package com.edu.repository.impl;

import com.edu.pojo.Admin;
import com.edu.pojo.Shipper;
import com.edu.pojo.User;
import com.edu.repository.ShipperRepository;
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
import org.springframework.transaction.annotation.Propagation;
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

    @Override
    public List<Object[]> getShipperList(String filterType, String username, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootShipper = query.from(Shipper.class);
        Root rootUser = query.from(User.class);      

        // Lấy user là shipper
        query = query.where(builder.equal(rootUser.get("id"), rootShipper.get("shipperId")));
        
        // Nếu có truyền username để tìm kiếm
        if (username != null) {
            Predicate pre = builder.like(rootUser.get("username").as(String.class),
                    String.format("%%%s%%", username));
            query = query.where(pre);
        }
        
        if (filterType != null) {
            switch(filterType) {
                case "pending":
                    query = query.where(builder.isNull(rootUser.get("shipper").get("approvedBy")));
                    break;
                    
                case "active":
                    query = query.where(builder.equal(rootUser.get("active").as(Integer.class), 1));
                    break;
                    
                case "inactive":
                    query = query.where(builder.equal(rootUser.get("active").as(Integer.class), 0));
                    break;
                    
                default:
                    break;
            }
        }
        
        // Tài khoản mới nhất lên trước
        query = query.orderBy(builder.asc(rootUser.get("id")));
        
        // Bóc tách ra một số trường bỏ vào list (ra UI truy cập dạng như array)
        query = query.multiselect(
                rootUser.get("id"),
                rootUser.get("username"),
                rootUser.get("firstName"),
                rootUser.get("lastName"),
                rootUser.get("email"),
                rootUser.get("phone"),
                rootUser.get("avatar"),
                rootUser.get("joinedDate"),
                rootUser.get("shipper").get("idCard"),
                rootUser.get("shipper").get("avgRating"),
                rootUser.get("active"),
                rootUser.get("shipper").get("approvedBy").get("adminId")
        );
        
        // Gom nhóm theo id
        query = query.groupBy(rootUser.get("id"));
        
        // Tạo truy vấn
        Query q = session.createQuery(query);
        // Phân trang kết quả
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public boolean deactivateShipper(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        User userAsShipper = session.get(User.class, shipperId);
        userAsShipper.setActive((short) 0);
        
        try {
            session.update(userAsShipper);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean activateShipper(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        User userAsShipper = session.get(User.class, shipperId);
        userAsShipper.setActive((short) 1);
        
        try {
            session.update(userAsShipper);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean approveShipper(int adminId, int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Admin admin = session.get(Admin.class, adminId);        
        Shipper shipper = session.get(Shipper.class, shipperId);
        User userAsShipper = session.get(User.class, shipperId);
        shipper.setApprovedBy(admin);
        userAsShipper.setActive((short) 1);
                
        try {
            session.saveOrUpdate(userAsShipper);
            session.saveOrUpdate(shipper);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean partialUpdateByAdmin(int shipperId, String email, String phone, String idCard) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Shipper shipper = session.get(Shipper.class, shipperId);
        User userAsShipper = session.get(User.class, shipperId);
        userAsShipper.setEmail(email);
        userAsShipper.setPhone(phone);
        shipper.setIdCard(idCard);
        
        try {
            session.saveOrUpdate(userAsShipper);
            session.saveOrUpdate(shipper);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public int countShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("Select COUNT(*) From Shipper");
         
        return Integer.parseInt(query.getSingleResult().toString());
    }
    
}
