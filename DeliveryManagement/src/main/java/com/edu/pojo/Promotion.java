package com.edu.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auction")
public class Promotion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String description;
    
    private int quantity;
    
    @Column(name = "applicable_for")
    private String applicableFor;
    
    @Column(name = "issue_date")
    private Timestamp issueDate;
    
    @Column(name = "end_date")
    private Timestamp endDate;
    
    private BigDecimal amount;
    
    @Column(name = "coupon_code")
    private String couponCode;
    
    @OneToMany(mappedBy = "promotion")
    private Set<Order> orders;
    
    @ManyToOne
    @JoinColumn(name = "created_by")
    private SysAdmin sysAdmin;
    
    // Getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getApplicableFor() {
        return applicableFor;
    }

    public void setApplicableFor(String applicableFor) {
        this.applicableFor = applicableFor;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public SysAdmin getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(SysAdmin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }
    
}