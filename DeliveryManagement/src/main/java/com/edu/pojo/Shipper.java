package com.edu.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipper")
public class Shipper implements Serializable {
    private int shipperId;
    private String avatar;
    private String idCard;
    private float avgRating;
    
}