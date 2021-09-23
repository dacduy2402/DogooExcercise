package com.speedhome.poc.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "PROPERTY")
public class PropertyEntity {

    @Id
    @Column(name = "PROPERTY_ID", nullable = false)
    private String id;

    @Column(name = "PROPERTY_NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String desc;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "PROPERTY_TYPE", nullable = false)
    private String type;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "STATUS_COMMENT")
    private String statusComment;

    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    @Column(name = "UPDATED_USR_ID")
    private String updatedUserId;

    @Column(name = "UPDATED_TIMSTM")
    private Timestamp updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }

    public Timestamp getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
