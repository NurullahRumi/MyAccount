package com.nrproject.myaccount.repo;

import com.nrproject.myaccount.entity.ReceivedInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedInterestRepository extends JpaRepository<ReceivedInterest, Integer> {
}