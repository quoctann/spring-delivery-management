/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quoctan
 */
@Entity
@Table(name = "reported_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportedOrder.findAll", query = "SELECT r FROM ReportedOrder r"),
    @NamedQuery(name = "ReportedOrder.findByOrderId", query = "SELECT r FROM ReportedOrder r WHERE r.orderId = :orderId"),
    @NamedQuery(name = "ReportedOrder.findByDescription", query = "SELECT r FROM ReportedOrder r WHERE r.description = :description"),
    @NamedQuery(name = "ReportedOrder.findBySolution", query = "SELECT r FROM ReportedOrder r WHERE r.solution = :solution"),
    @NamedQuery(name = "ReportedOrder.findByTicketStatus", query = "SELECT r FROM ReportedOrder r WHERE r.ticketStatus = :ticketStatus")})
public class ReportedOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "solution")
    private String solution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ticket_status")
    private String ticketStatus;
    @JoinColumns({
        @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Order order1;
    @JoinColumn(name = "assigned_to", referencedColumnName = "admin_id")
    @ManyToOne
    private SysAdmin assignedTo;

    public ReportedOrder() {
    }

    public ReportedOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public ReportedOrder(Integer orderId, String description, String solution, String ticketStatus) {
        this.orderId = orderId;
        this.description = description;
        this.solution = solution;
        this.ticketStatus = ticketStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Order getOrder1() {
        return order1;
    }

    public void setOrder1(Order order1) {
        this.order1 = order1;
    }

    public SysAdmin getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(SysAdmin assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportedOrder)) {
            return false;
        }
        ReportedOrder other = (ReportedOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.ReportedOrder[ orderId=" + orderId + " ]";
    }
    
}
