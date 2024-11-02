package com.nrproject.myaccount.controller;

import com.nrproject.myaccount.entity.ReceivedInterest;
import com.nrproject.myaccount.exception.custom.FieldRequired;
import com.nrproject.myaccount.exception.custom.NotLessThenZero;
import com.nrproject.myaccount.service.ReceivedInterestService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/addrecint")
    public ReceivedInterest addRecInt(@RequestBody ReceivedInterest receivedInterest){

        if(receivedInterest.getRecIntDate() == null){
            throw new FieldRequired("Interest received date required.");
        }

        if(receivedInterest.getRecIntSource() == null || receivedInterest.getRecIntSource().isEmpty()){
            throw new FieldRequired("Interest source is required.");
        }

        if(receivedInterest.getRecIntAmount() == null){
            throw new FieldRequired("Received Interest amount is required.");
        }

        if(receivedInterest.getRecIntAmount() < 0){
            throw new NotLessThenZero("Amount cannot be less then 0");
        }

        ReceivedInterest objToService = new ReceivedInterest();

        objToService.setRecIntDate(receivedInterest.getRecIntDate());
        objToService.setRecIntSource(receivedInterest.getRecIntSource());
        objToService.setRecIntAmount(receivedInterest.getRecIntAmount());
        objToService.setRecIntRemarks(receivedInterest.getRecIntRemarks());
        objToService.setCreatedBy("WIP");
        objToService.setCreatedDate(new Date());

        return receivedInterestService.addRecInt(objToService);
    }

}
