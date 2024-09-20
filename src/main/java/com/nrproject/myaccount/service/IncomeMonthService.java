package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.IncomeMonths;
import com.nrproject.myaccount.repo.IncomeMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeMonthService {

    @Autowired
    private IncomeMonthRepository incomeMonthRepository;

    public List<IncomeMonths> getAll() {
        return incomeMonthRepository.findAll();
    }

    public IncomeMonths getById(int id) {
        return incomeMonthRepository.findById(id).get();
    }

    public IncomeMonths save(IncomeMonths incomeMonths) {
        return incomeMonthRepository.save(incomeMonths);
    }
}
