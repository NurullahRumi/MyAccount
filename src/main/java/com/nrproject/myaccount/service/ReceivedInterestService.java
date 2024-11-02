package com.nrproject.myaccount.service;

import com.nrproject.myaccount.entity.ReceivedInterest;
import com.nrproject.myaccount.exception.custom.FieldRequired;
import com.nrproject.myaccount.exception.custom.NotFoundException;
import com.nrproject.myaccount.exception.custom.NotLessThenZero;
import com.nrproject.myaccount.repo.ReceivedInterestRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReceivedInterestService {
    private final ReceivedInterestRepository receivedInterestRepository;

    public ReceivedInterestService(ReceivedInterestRepository receivedInterestRepository) {
        this.receivedInterestRepository = receivedInterestRepository;
    }

    public List<ReceivedInterest> findAll(){
        List<ReceivedInterest> receivedInterests;
        receivedInterests = receivedInterestRepository.findAll();

        if (receivedInterests.isEmpty()){
            throw new NotFoundException("No data found.");
        }

        return receivedInterests;
    }

    public Optional<ReceivedInterest> findById(int id){

        List<ReceivedInterest> receivedInterests;
        receivedInterests = receivedInterestRepository.findAll();

        Optional<ReceivedInterest> receivedInterest;
        receivedInterest = receivedInterestRepository.findById(id);

        if(id > receivedInterests.size() || id < 0){
            throw new NotFoundException("Received interest Id is not correct.");
        }

        return receivedInterest;
    }

    public ReceivedInterest addRecInt(ReceivedInterest receivedInterest){
        return receivedInterestRepository.save(receivedInterest);
    }



}
