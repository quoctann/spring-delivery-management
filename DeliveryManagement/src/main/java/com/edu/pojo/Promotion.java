package com.edu.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "auction")
public class Promotion implements Serializable {
    
    private int id;
    private String description;
    private int quantity;
    private String applicableFor;
    private Timestamp issueDate;
    private Timestamp endDate;
    private BigDecimal amount;
    private String couponCode;
    
    
}