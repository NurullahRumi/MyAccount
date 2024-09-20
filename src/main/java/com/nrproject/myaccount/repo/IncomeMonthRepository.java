package com.nrproject.myaccount.repo;

import com.nrproject.myaccount.entity.IncomeMonths;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeMonthRepository extends JpaRepository<IncomeMonths, Integer> {
}
