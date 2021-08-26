package com.edu.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review implements Serializable {
    private int id;
    private int shipperId;
    private int customerId;
    private String content;
    private float rate;
}