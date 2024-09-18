package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

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
//    @Column(name = "month_id")
//    private int monthId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monthId")
    private IncomeMonths incomeMonths;

    public Income(Double amount, String remarks, int monthId) {
        this.amount = amount;
        this.remarks = remarks;
        //this.monthId = monthId;
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

//    public int getMonthId() {
//        return monthId;
//    }

//    public void setMonthId(int monthId) {
//        this.monthId = monthId;
//    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeId=" + incomeId +
                ", amount=" + amount +
                ", remarks='" + remarks + '\'' +

                '}';
    }
}
