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
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findById", query = "SELECT r FROM Review r WHERE r.id = :id"),
    @NamedQuery(name = "Review.findByContent", query = "SELECT r FROM Review r WHERE r.content = :content"),
    @NamedQuery(name = "Review.findByRate", query = "SELECT r FROM Review r WHERE r.rate = :rate")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private float rate;
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Order order1;

    public Review() {
    }

    public Review(Integer id) {
        this.id = id;
    }

    public Review(Integer id, String content, float rate) {
        this.id = id;
        this.content = content;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Order getOrder1() {
        return order1;
    }

    public void setOrder1(Order order1) {
        this.order1 = order1;
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
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.pojo.Review[ id=" + id + " ]";
    }
    
}
