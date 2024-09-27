package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.Months;
import com.nrproject.myaccount.exception.custom.NotFoundException;
import com.nrproject.myaccount.service.MonthService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/month")
public class MonthController {

    private final MonthService monthService;
    private List<Months> theMonths;

    public MonthController(MonthService monthService) {
        this.monthService = monthService;
    }


    @PostConstruct
    public void init() {
        theMonths = new ArrayList<>();
        theMonths = monthService.getAll();
    }


    @GetMapping("/months")
    public List<Months> incomeMonths() {
        return theMonths;
    }

    @GetMapping("/months/{id}")
    public Months incomeMonths(@PathVariable int id) {

        // check the income month id list size
        if( id >= theMonths.size() || id < 0){
            throw new NotFoundException("month ID " + id + " not found");
        }

        return monthService.getById(id);
    }

    @PostMapping("/addMonth")
    public Months addIncomeMonth(@RequestBody Months months) {
        return monthService.save(months);
    }

    @PutMapping("/editMonth")
    public Months editIncomeMonth(@RequestBody Months months) {
        Months existingIncomeMonth = monthService.getById(months.getMonthId());
        existingIncomeMonth.setMonthNam(months.getMonthNam());

        return monthService.save(existingIncomeMonth);
    }

    @DeleteMapping("/deleteMonth")
    public void deleteIncomeMonth(@RequestBody Months months) {
        Months existingIncomeMonth = monthService.getById(months.getMonthId());
        monthService.delete(existingIncomeMonth);
    }

    @DeleteMapping("/deleteMonthById/{id}")
    public void removeIncomeMonthById(@PathVariable int id) {
        // check the income month id list size
        if( id >= theMonths.size() || id < 0){
            throw new NotFoundException("month ID " + id + " not found");
        }
        Months months = monthService.getById(id);
        monthService.delete(months);
    }
}
