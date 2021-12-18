package com.edu.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    
    @Size(max = 100)
    @Column(name = "avatar")
    private String avatar;
    
    @Size(max = 50)
    @Column(name = "id_card")
    private String idCard;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avg_rating")
    private Float avgRating;
    
    @JoinColumn(name = "approved_by", referencedColumnName = "admin_id")
    @ManyToOne
    private Admin approvedBy;
    
    @OneToOne(mappedBy = "shipper")
    private User user;
    
    @OneToMany(mappedBy = "shipperId")
    private Set<Comment> commentSet;
    
    @OneToMany(mappedBy = "shipperId")
    private Set<Auction> auctionSet;
    
    @OneToMany(mappedBy = "shipperId")
    private Set<Order> orderSet;

    public Shipper() {
    }

    public Shipper(Integer shipperId) {
        this.shipperId = shipperId;
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

    public Float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }

    public Admin getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Admin approvedBy) {
        this.approvedBy = approvedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @XmlTransient
    public Set<Auction> getAuctionSet() {
        return auctionSet;
    }

    public void setAuctionSet(Set<Auction> auctionSet) {
        this.auctionSet = auctionSet;
    }

    @XmlTransient
    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
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
