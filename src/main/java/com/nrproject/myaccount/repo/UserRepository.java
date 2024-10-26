package com.nrproject.myaccount.repo;

import com.nrproject.myaccount.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <Users, String>{
}
