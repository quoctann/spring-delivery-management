package com.edu.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.findById", query = "SELECT o FROM Order o WHERE o.id = :id"),
    @NamedQuery(name = "Order.findByCreatedDate", query = "SELECT o FROM Order o WHERE o.createdDate = :createdDate"),
    @NamedQuery(name = "Order.findByCompletedDate", query = "SELECT o FROM Order o WHERE o.completedDate = :completedDate"),
    @NamedQuery(name = "Order.findByStatus", query = "SELECT o FROM Order o WHERE o.status = :status"),
    @NamedQuery(name = "Order.findByDescription", query = "SELECT o FROM Order o WHERE o.description = :description"),
    @NamedQuery(name = "Order.findByReceiverPhone", query = "SELECT o FROM Order o WHERE o.receiverPhone = :receiverPhone"),
    @NamedQuery(name = "Order.findBySentFrom", query = "SELECT o FROM Order o WHERE o.sentFrom = :sentFrom"),
    @NamedQuery(name = "Order.findBySentTo", query = "SELECT o FROM Order o WHERE o.sentTo = :sentTo"),
    @NamedQuery(name = "Order.findByPaymentMethod", query = "SELECT o FROM Order o WHERE o.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Order.findByType", query = "SELECT o FROM Order o WHERE o.type = :type"),
    @NamedQuery(name = "Order.findByTransactionId", query = "SELECT o FROM Order o WHERE o.transactionId = :transactionId"),
    @NamedQuery(name = "Order.findByRateStar", query = "SELECT o FROM Order o WHERE o.rateStar = :rateStar")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Column(name = "completed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;
    
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    
    @Size(max = 15)
    @Column(name = "receiver_phone")
    private String receiverPhone;
    
    @Size(max = 255)
    @Column(name = "sent_from")
    private String sentFrom;
    
    @Size(max = 255)
    @Column(name = "sent_to")
    private String sentTo;
    
    @Size(max = 45)
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    
    @Size(max = 100)
    @Column(name = "transaction_id")
    private String transactionId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate_star")
    private Float rateStar;
    
    @OneToMany(mappedBy = "orderId")
    private Set<Auction> auctionSet;
    
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    
    @JoinColumn(name = "shipper_id", referencedColumnName = "shipper_id")
    @ManyToOne
    private Shipper shipperId;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Float getRateStar() {
        return rateStar;
    }

    public void setRateStar(Float rateStar) {
        this.rateStar = rateStar;
    }

    @XmlTransient
    public Set<Auction> getAuctionSet() {
        return auctionSet;
    }

    public void setAuctionSet(Set<Auction> auctionSet) {
        this.auctionSet = auctionSet;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Shipper getShipperId() {
        return shipperId;
    }

    public void setShipperId(Shipper shipperId) {
        this.shipperId = shipperId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.Order1[ id=" + id + " ]";
    }
    
}
