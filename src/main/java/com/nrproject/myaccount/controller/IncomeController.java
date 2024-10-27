package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.Income;
import com.nrproject.myaccount.exception.custom.NotFoundException;
import com.nrproject.myaccount.service.IncomeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;
    private List<Income> incomes;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

//    @PostConstruct
//    public void init() {
//        incomes = new ArrayList<>();
//        incomes = incomeService.getAll();
//    }


    @GetMapping("/session")
    public String sessionId(HttpServletRequest request){
        return "Session Id is: " + request.getSession().getId();
    }

    @GetMapping("/incomes")
    public List<Income> incomes() {
        incomes = new ArrayList<>();
        incomes = incomeService.getAll();
        if (incomes.size() == 0) {
            throw new NotFoundException("No Incomes found");
        }
        return incomes;
    }

    @GetMapping("/incomes/{id}")
    public Income getIncome(@PathVariable int id) {

        // check the income list size
        if( id >= incomes.size() || id < 0){
            throw new NotFoundException("Income ID " + id + " not found");
        }

        return incomeService.getIncomeById(id);
    }

    @PostMapping("/addIncome")
    public Income addIncome(@RequestBody Income income) {
        Income newIncome = new Income();
        newIncome.setAmount(income.getAmount());
        newIncome.setRemarks(income.getRemarks());
        newIncome.setCreatedBy("test");
        newIncome.setCreatedDate(new Date());
        newIncome.setMonths(income.getMonths());
        return incomeService.save(newIncome);
    }

    @PutMapping("/editIncome")
    public Income editIncome(@RequestBody Income income) {
        Income dbRecord = incomeService.getIncomeById(income.getIncomeId());
        dbRecord.setAmount(income.getAmount());
        dbRecord.setRemarks(income.getRemarks());
        dbRecord.setCreatedBy(dbRecord.getCreatedBy());
        dbRecord.setCreatedDate(dbRecord.getCreatedDate());
        dbRecord.setUpdatedBy("WIP");
        dbRecord.setUpdatedDate(new Date());
        dbRecord.setMonths(dbRecord.getMonths());
        return incomeService.save(dbRecord);
    }

    @DeleteMapping("/deleteIncome")
    public void deleteIncome(@PathVariable int id) {
        // check the income list size
        if( id >= incomes.size() || id < 0){
            throw new NotFoundException("Income ID " + id + " not found");
        }
        incomeService.deleteIncomeById(id);
    }
}
