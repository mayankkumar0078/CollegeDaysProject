package com.collegeDays.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.collegeDays.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaSpecificationExecutor<Faculty>, JpaRepository<Faculty, Integer> {
}
