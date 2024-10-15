package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "nr_income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private int incomeId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "create_by")
    private String createdBy;
    @Column(name = "create_dat")
    private Date createdDate;
    @Column(name = "update_by")
    private String updatedBy;
    @Column(name = "update_dat")
    private Date updatedDate;

    @OneToOne(targetEntity = Months.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "month_id",referencedColumnName = "month_id")
    private Months months;

    public Income(Double amount, String remarks, String createdBy, Date createdDate, String updatedBy, Date updatedDate, Months months) {
        this.amount = amount;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.months = months;
    }

    public Income() {}

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Months getMonths() {
        return months;
    }

    public void setMonths(Months months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return "Income{" +
                "amount=" + amount +
                ", remarks='" + remarks + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
