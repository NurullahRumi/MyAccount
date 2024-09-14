package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.Income;
import com.nrproject.myaccount.repo.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAll() {
        return incomeRepository.findAll();
    }

    public Income getIncomeById(int id) {
        return incomeRepository.findById(id).get();
    }

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }
}
