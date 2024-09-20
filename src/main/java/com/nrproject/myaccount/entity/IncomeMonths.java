package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nr_income_month")
public class IncomeMonths {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "month_id")
    private int monthId;
    @Column(name = "month_nam")
    private String monthNam;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incomeMonths", cascade = CascadeType.ALL)
    private List<Income> incomeList;

    public IncomeMonths( String monthNam) {
        this.monthNam = monthNam;
    }

    public IncomeMonths() {}

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public String getMonthNam() {
        return monthNam;
    }

    public void setMonthNam(String monthNam) {
        this.monthNam = monthNam;
    }

    @Override
    public String toString() {
        return "IncomeMonths{" +
                "monthId=" + monthId +
                ", monthNam='" + monthNam + '\'' +
                '}';
    }
}
