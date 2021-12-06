/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quoctan
 */
@Entity
@Table(name = "sys_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysAdmin.findAll", query = "SELECT s FROM SysAdmin s"),
    @NamedQuery(name = "SysAdmin.findByAdminId", query = "SELECT s FROM SysAdmin s WHERE s.adminId = :adminId"),
    @NamedQuery(name = "SysAdmin.findByOffice", query = "SELECT s FROM SysAdmin s WHERE s.office = :office")})
public class SysAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin_id")
    private Integer adminId;
    @Size(max = 45)
    @Column(name = "office")
    private String office;
    @OneToMany(mappedBy = "approvedBy")
    private Collection<Shipper> shipperCollection;
    @OneToMany(mappedBy = "assignedTo")
    private Collection<ReportedOrder> reportedOrderCollection;
    @JoinColumns({
        @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Promotion> promotionCollection;

    public SysAdmin() {
    }

    public SysAdmin(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysAdmin)) {
            return false;
        }
        SysAdmin other = (SysAdmin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.SysAdmin[ adminId=" + adminId + " ]";
    }
    
}
