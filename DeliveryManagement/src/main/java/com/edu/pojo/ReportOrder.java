package com.edu.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "report_order")
public class ReportOrder implements Serializable {
    // Trạng thái ticket của một đơn hàng bị báo cáo (ticket_status)
    public static final String OPENED = "OPENED";
    public static final String CLOSED = "CLOSED";
    public static final String SOLVING = "SOLVING";
    
    private int orderId;
    private String description;
    private String solution;
    private String ticket_status;
}