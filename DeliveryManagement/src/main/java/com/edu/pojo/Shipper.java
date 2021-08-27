package com.edu.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipper")
public class Shipper implements Serializable {
    
    @Id
    private int id;
    
    @OneToOne(mappedBy = "shipper", cascade = CascadeType.ALL)
    private User user;
    
    private String avatar;
    
    @Column(name = "pending_approval")
    private boolean pendingApproval;
    
    @Column(name = "id_card")
    private String idCard;
    
    @Column(name = "avg_rating")
    private float avgRating;
 
    @OneToMany(mappedBy = "shipper")
    private Set<Auction> auctions;

    @OneToMany(mappedBy = "shipper")
    private Set<Order> orders;
    
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private SysAdmin sysAdmin;
    
    // Getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public boolean isPendingApproval() {
        return pendingApproval;
    }

    public void setPendingApproval(boolean pendingApproval) {
        this.pendingApproval = pendingApproval;
    }

    public SysAdmin getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(SysAdmin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }
    
}