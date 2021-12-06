/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
@Table(name = "shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s"),
    @NamedQuery(name = "Shipper.findByShipperId", query = "SELECT s FROM Shipper s WHERE s.shipperId = :shipperId"),
    @NamedQuery(name = "Shipper.findByAvatar", query = "SELECT s FROM Shipper s WHERE s.avatar = :avatar"),
    @NamedQuery(name = "Shipper.findByIdCard", query = "SELECT s FROM Shipper s WHERE s.idCard = :idCard"),
    @NamedQuery(name = "Shipper.findByAvgRating", query = "SELECT s FROM Shipper s WHERE s.avgRating = :avgRating")})
public class Shipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipper_id")
    private Integer shipperId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_card")
    private String idCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avg_rating")
    private float avgRating;
    @ManyToMany(mappedBy = "shipperCollection")
    private Collection<Order> order1Collection;
    @JoinColumn(name = "approved_by", referencedColumnName = "admin_id")
    @ManyToOne
    private SysAdmin approvedBy;
    @JoinColumns({
        @JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(mappedBy = "shipper")
    private Collection<Order> order1Collection1;

    public Shipper() {
    }

    public Shipper(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public Shipper(Integer shipperId, String avatar, String idCard, float avgRating) {
        this.shipperId = shipperId;
        this.avatar = avatar;
        this.idCard = idCard;
        this.avgRating = avgRating;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    @XmlTransient
    public Collection<Order> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public SysAdmin getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(SysAdmin approvedBy) {
        this.approvedBy = approvedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Order> getOrder1Collection1() {
        return order1Collection1;
    }

    public void setOrder1Collection1(Collection<Order> order1Collection1) {
        this.order1Collection1 = order1Collection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperId != null ? shipperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.shipperId == null && other.shipperId != null) || (this.shipperId != null && !this.shipperId.equals(other.shipperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.Shipper[ shipperId=" + shipperId + " ]";
    }
    
}
