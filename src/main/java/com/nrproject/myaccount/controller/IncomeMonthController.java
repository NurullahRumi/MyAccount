package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.IncomeMonths;
import com.nrproject.myaccount.exception.custom.DataTypeMismatchException;
import com.nrproject.myaccount.exception.custom.NotFoundException;
import com.nrproject.myaccount.service.IncomeMonthService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/incomemonth")
public class IncomeMonthController {

    private final IncomeMonthService incomeMonthService;
    private List<IncomeMonths> theIncomeMonths;

    public IncomeMonthController(IncomeMonthService incomeMonthService) {
        this.incomeMonthService = incomeMonthService;
    }


    @PostConstruct
    public void init() {
        theIncomeMonths = new ArrayList<>();
        theIncomeMonths = incomeMonthService.getAll();
    }


    @GetMapping("/incomemonths")
    public List<IncomeMonths> incomeMonths() {
        return theIncomeMonths;
    }

    @GetMapping("/incomemonths/{id}")
    public IncomeMonths incomeMonths(@PathVariable int id) {

        // check the income month id list size
        if( id >= theIncomeMonths.size() || id < 0){
            throw new NotFoundException("Income month ID " + id + " not found");
        }

        return incomeMonthService.getById(id);
    }

    @PostMapping("/addIncomeMonth")
    public IncomeMonths addIncomeMonth(@RequestBody IncomeMonths incomeMonths) {
        return incomeMonthService.save(incomeMonths);
    }

    @PutMapping("/editIncomeMonth")
    public IncomeMonths editIncomeMonth(@RequestBody IncomeMonths incomeMonths) {
        IncomeMonths existingIncomeMonth = incomeMonthService.getById(incomeMonths.getMonthId());
        existingIncomeMonth.setMonthNam(incomeMonths.getMonthNam());

        return incomeMonthService.save(existingIncomeMonth);
    }

    @DeleteMapping("/deleteIncomeMonth")
    public void deleteIncomeMonth(@RequestBody IncomeMonths incomeMonths) {
        IncomeMonths existingIncomeMonth = incomeMonthService.getById(incomeMonths.getMonthId());
        incomeMonthService.delete(existingIncomeMonth);
    }

    @DeleteMapping("/deleteIncomeMonthById/{id}")
    public void removeIncomeMonthById(@PathVariable int id) {
        IncomeMonths incomeMonths = incomeMonthService.getById(id);
        incomeMonthService.delete(incomeMonths);
    }
}
