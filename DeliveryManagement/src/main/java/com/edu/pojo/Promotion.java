/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quoctan
 */
@Entity
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findById", query = "SELECT p FROM Promotion p WHERE p.id = :id"),
    @NamedQuery(name = "Promotion.findByDescription", query = "SELECT p FROM Promotion p WHERE p.description = :description"),
    @NamedQuery(name = "Promotion.findByQuantity", query = "SELECT p FROM Promotion p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Promotion.findByApplicableFor", query = "SELECT p FROM Promotion p WHERE p.applicableFor = :applicableFor"),
    @NamedQuery(name = "Promotion.findByIssueDate", query = "SELECT p FROM Promotion p WHERE p.issueDate = :issueDate"),
    @NamedQuery(name = "Promotion.findByEndDate", query = "SELECT p FROM Promotion p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Promotion.findByAmount", query = "SELECT p FROM Promotion p WHERE p.amount = :amount"),
    @NamedQuery(name = "Promotion.findByCouponCode", query = "SELECT p FROM Promotion p WHERE p.couponCode = :couponCode")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Size(max = 45)
    @Column(name = "applicable_for")
    private String applicableFor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private long amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "coupon_code")
    private String couponCode;
    @OneToMany(mappedBy = "promotion")
    private Collection<Order> order1Collection;
    @JoinColumn(name = "created_by", referencedColumnName = "admin_id")
    @ManyToOne(optional = false)
    private SysAdmin createdBy;

    public Promotion() {
    }

    public Promotion(Integer id) {
        this.id = id;
    }

    public Promotion(Integer id, String description, int quantity, Date issueDate, Date endDate, long amount, String couponCode) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.issueDate = issueDate;
        this.endDate = endDate;
        this.amount = amount;
        this.couponCode = couponCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @XmlTransient
    public Collection<Order> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public SysAdmin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(SysAdmin createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.Promotion[ id=" + id + " ]";
    }
    
}
