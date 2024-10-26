package com.nrproject.myaccount.repo;

import com.nrproject.myaccount.entity.UserRole;
import com.nrproject.myaccount.entity.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {
}
