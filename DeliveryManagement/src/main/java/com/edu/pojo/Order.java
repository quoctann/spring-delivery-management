package com.edu.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    private int id;
    private int customerId;
    private Timestamp issueDate;
    private Timestamp endDate;
    private String status;
    private String description;
    private String sentFrom;
    private String sentTo;
    private String paymentMethod;
    private int promoId;

}
