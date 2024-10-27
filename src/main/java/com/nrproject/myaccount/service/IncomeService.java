package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.Income;
import com.nrproject.myaccount.repo.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAll() {
        return incomeRepository.findAll();
    }

    public Income getIncomeById(int id) {
        return incomeRepository.findById(id).get();
    }

    public Income save(Income income) {
        return incomeRepository.save(income);
    }

    public void deleteIncomeById(int id) {
        incomeRepository.deleteById(id);
    }
}
