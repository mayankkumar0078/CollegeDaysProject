package com.collegeDays.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.collegeDays.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaSpecificationExecutor<UserType>, JpaRepository<UserType, Integer> {
}
