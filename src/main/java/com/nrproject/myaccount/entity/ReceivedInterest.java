package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "nr_received_interest")
public class ReceivedInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_int_id")
    private int recIntId;
    @Column(name = "rec_int_date")
    private Date recIntDate;
    @Column(name = "rec_int_source")
    private String recIntSource;
    @Column(name = "rec_int_amount")
    private Float recIntAmount;
    @Column(name = "remarks")
    private String recIntRemarks;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_dat")
    private Date createdDate;
    @Column(name = "update_by")
    private String updatedBy;
    @Column(name = "updated_dat")
    private Date updatedDate;

    public ReceivedInterest(Date recIntDate, String recIntSource, float recIntAmount, String recIntRemarks, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
        this.recIntDate = recIntDate;
        this.recIntSource = recIntSource;
        this.recIntAmount = recIntAmount;
        this.recIntRemarks = recIntRemarks;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public ReceivedInterest(){}

    public int getRecIntId() {
        return recIntId;
    }

    public void setRecIntId(int recIntId) {
        this.recIntId = recIntId;
    }

    public Date getRecIntDate() {
        return recIntDate;
    }

    public void setRecIntDate(Date recIntDate) {
        this.recIntDate = recIntDate;
    }

    public String getRecIntSource() {
        return recIntSource;
    }

    public void setRecIntSource(String recIntSource) {
        this.recIntSource = recIntSource;
    }

    public Float getRecIntAmount() {
        return recIntAmount;
    }

    public void setRecIntAmount(Float recIntAmount) {
        this.recIntAmount = recIntAmount;
    }

    public String getRecIntRemarks() {
        return recIntRemarks;
    }

    public void setRecIntRemarks(String recIntRemarks) {
        this.recIntRemarks = recIntRemarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "ReceivedInterest{" +
                "recIntId=" + recIntId +
                ", recIntDate=" + recIntDate +
                ", recIntSource='" + recIntSource + '\'' +
                ", recIntAmount=" + recIntAmount +
                ", recIntRemarks='" + recIntRemarks + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
