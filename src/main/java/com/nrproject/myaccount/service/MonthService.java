package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.Months;
import com.nrproject.myaccount.repo.MonthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {

    private final MonthRepository monthRepository;

    public MonthService(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    public List<Months> getAll() {
        return monthRepository.findAll();
    }

    public Months getById(int id) {
        return monthRepository.findById(id).get();
    }

    public Months save(Months months) {
        return monthRepository.save(months);
    }

    public void delete(Months months) {
        monthRepository.delete(months);
    }
    
}
