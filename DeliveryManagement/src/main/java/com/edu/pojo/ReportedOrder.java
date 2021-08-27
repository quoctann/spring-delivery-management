package com.edu.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report_order")
public class ReportedOrder implements Serializable {
    
    // Trạng thái ticket của một đơn hàng bị báo cáo (ticket_status)
    public static final String OPENED = "OPENED";
    public static final String CLOSED = "CLOSED";
    public static final String SOLVING = "SOLVING";
    
    @Id
    private int id;
    
    @OneToOne(mappedBy = "report")
    private Order order;
    
    private String description;
    
    private String solution;
    
    @Column(name = "ticket_status")
    private String ticketStatus;
    
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private SysAdmin sysAdmin;
    
    // Getter & setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticket_status) {
        this.ticketStatus = ticket_status;
    }

    public SysAdmin getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(SysAdmin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }
    
}