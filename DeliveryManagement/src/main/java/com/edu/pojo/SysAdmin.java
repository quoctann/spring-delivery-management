package com.edu.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_admin")
public class SysAdmin implements Serializable {
    
    // Các vai trò có quyền cao trong hệ thống
    public static final String ADMIN = "ADMIN";
    public static final String STAFF = "STAFF";
    
    @Id
    private int id;
    
    @OneToOne(mappedBy = "sysAdmin")
    private User user;
    
    private String office;
    
    @OneToMany(mappedBy = "sysAdmin")
    private Set<Shipper> shippers;
    
    @OneToMany(mappedBy = "sysAdmin")
    private Set<ReportedOrder> reports;
    
    @OneToMany(mappedBy = "sysAdmin")
    private Set<Promotion> promotions;
    
    // Getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Set<Shipper> getShippers() {
        return shippers;
    }

    public void setShippers(Set<Shipper> shippers) {
        this.shippers = shippers;
    }

    public Set<ReportedOrder> getReports() {
        return reports;
    }

    public void setReports(Set<ReportedOrder> reports) {
        this.reports = reports;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
    
}
