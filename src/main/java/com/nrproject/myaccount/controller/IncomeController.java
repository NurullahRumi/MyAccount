package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.Income;
import com.nrproject.myaccount.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/incomes")
    public List<Income> incomes() {
        return incomeService.getAll();
    }

    @GetMapping("/incomes/{id}")
    public Income getIncome(@PathVariable int id) {
        return incomeService.getIncomeById(id);
    }

    @PostMapping("/addIncome")
    public Income addIncome(@RequestBody Income income) {
        return incomeService.addIncome(income);
    }
}
