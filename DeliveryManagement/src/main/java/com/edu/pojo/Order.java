package com.edu.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    // Các trạng thái vận chuyển của đơn hàng (status)
    public static final String DELIVERED = "DELIVERED";
    public static final String CANCELLED = "CANCELLED";
    public static final String TRANSPORTING = "TRANSPORTING";
    public static final String CREATED = "CREATED";
    public static final String ACCEPTED = "ACCEPTED";
    
    // Các phương thức thanh toán (payment_method)
    public static final String CASH = "CASH";
    public static final String EWALLET = "EWALLET";
    
    // Loại đơn hàng như nhẹ, cồng kềnh,... (type)
    public static final String FOOD = "FOOD";
    public static final String DOCUMENT = "DOCUMENT";
    public static final String HEAVY = "HEAVY";
    public static final String MEDIUM = "MEDIUM";
    
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @OneToMany(mappedBy = "order")
    private Set<Auction> auctions;
    
    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;
    
    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promotion promotion;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ReportedOrder report;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Review review;
    
    private Timestamp issueDate;
    
    private Timestamp endDate;
    
    private String status;
    
    private String description;
    
    private String sentFrom;
    
    private String sentTo;
    
    private String paymentMethod;
    
    private String transactionId;
        
    // Getter & setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public ReportedOrder getReport() {
        return report;
    }

    public void setReport(ReportedOrder report) {
        this.report = report;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    
}
