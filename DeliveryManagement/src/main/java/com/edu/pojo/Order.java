/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByIssueDate", query = "SELECT o FROM Order1 o WHERE o.issueDate = :issueDate"),
    @NamedQuery(name = "Order1.findByEndDate", query = "SELECT o FROM Order1 o WHERE o.endDate = :endDate"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByDescription", query = "SELECT o FROM Order1 o WHERE o.description = :description"),
    @NamedQuery(name = "Order1.findBySentFrom", query = "SELECT o FROM Order1 o WHERE o.sentFrom = :sentFrom"),
    @NamedQuery(name = "Order1.findBySentTo", query = "SELECT o FROM Order1 o WHERE o.sentTo = :sentTo"),
    @NamedQuery(name = "Order1.findByPaymentMethod", query = "SELECT o FROM Order1 o WHERE o.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Order1.findByType", query = "SELECT o FROM Order1 o WHERE o.type = :type"),
    @NamedQuery(name = "Order1.findByTransactionId", query = "SELECT o FROM Order1 o WHERE o.transactionId = :transactionId")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sent_from")
    private String sentFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sent_to")
    private String sentTo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "transaction_id")
    private String transactionId;
    @JoinTable(name = "auction", joinColumns = {
        @JoinColumn(name = "order_id", referencedColumnName = "id"),
        @JoinColumn(name = "order_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id"),
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id"),
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id")})
    @ManyToMany
    private Collection<Shipper> shipperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order1")
    private Collection<ReportedOrder> reportedOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order1")
    private Collection<Review> reviewCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumns({
        @JoinColumn(name = "promo_id", referencedColumnName = "id"),
        @JoinColumn(name = "promo_id", referencedColumnName = "id"),
        @JoinColumn(name = "promo_id", referencedColumnName = "id")})
    @ManyToOne
    private Promotion promotion;
    @JoinColumns({
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id"),
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id"),
        @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id")})
    @ManyToOne
    private Shipper shipper;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, Date issueDate, String status, String sentFrom, String sentTo, String paymentMethod, String type) {
        this.id = id;
        this.issueDate = issueDate;
        this.status = status;
        this.sentFrom = sentFrom;
        this.sentTo = sentTo;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlTransient
    public Collection<Shipper> getShipperCollection() {
        return shipperCollection;
    }

    public void setShipperCollection(Collection<Shipper> shipperCollection) {
        this.shipperCollection = shipperCollection;
    }

    @XmlTransient
    public Collection<ReportedOrder> getReportedOrderCollection() {
        return reportedOrderCollection;
    }

    public void setReportedOrderCollection(Collection<ReportedOrder> reportedOrderCollection) {
        this.reportedOrderCollection = reportedOrderCollection;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.Order1[ id=" + id + " ]";
    }
    
}
