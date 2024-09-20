package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.IncomeMonths;
import com.nrproject.myaccount.service.IncomeMonthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomemonth")
public class IncomeMonthController {

    private final IncomeMonthService incomeMonthService;

    public IncomeMonthController(IncomeMonthService incomeMonthService) {
        this.incomeMonthService = incomeMonthService;
    }


    @GetMapping("/incomemonths")
    public List<IncomeMonths> incomeMonths() {
        return incomeMonthService.getAll();
    }

    @GetMapping("/incomemonths/{id}")
    public IncomeMonths incomeMonths(@PathVariable int id) {
        return incomeMonthService.getById(id);
    }

    @PostMapping("/addIncomeMonth")
    public IncomeMonths addIncomeMonth(@RequestBody IncomeMonths incomeMonths) {
        return incomeMonthService.save(incomeMonths);
    }
}
