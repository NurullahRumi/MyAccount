package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.Income;
import com.nrproject.myaccount.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/incomes")
    public List<Income> incomes() {
        return incomeService.getAll();
    }
}
