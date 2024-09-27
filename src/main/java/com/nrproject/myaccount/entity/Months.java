package com.nrproject.myaccount.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nr_month")
public class Months {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "month_id")
    private int monthId;
    @Column(name = "month_nam")
    private String monthNam;

    public Months(String monthNam) {
        this.monthNam = monthNam;
    }

    public Months() {}

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
