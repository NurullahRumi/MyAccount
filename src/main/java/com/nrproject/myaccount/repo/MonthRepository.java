package com.nrproject.myaccount.repo;

import com.nrproject.myaccount.entity.Months;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Months, Integer> {
}
