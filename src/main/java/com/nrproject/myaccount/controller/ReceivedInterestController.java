package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.ReceivedInterest;
import com.nrproject.myaccount.service.ReceivedInterestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recint")
public class ReceivedInterestController {
    private final ReceivedInterestService receivedInterestService;

    public ReceivedInterestController(ReceivedInterestService receivedInterestService) {
        this.receivedInterestService = receivedInterestService;
    }

    @GetMapping("/allrecint")
    public List<ReceivedInterest> getAllRecInt(){
        return receivedInterestService.findAll();
    }

    @GetMapping("/recint/{id}")
    public Optional<ReceivedInterest> getRecInt(@PathVariable int id){
        return receivedInterestService.findById(id);
    }

}
