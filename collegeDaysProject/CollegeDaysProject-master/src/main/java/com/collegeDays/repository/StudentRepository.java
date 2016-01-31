package com.collegeDays.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.collegeDays.entity.Student;

@Repository
public interface StudentRepository extends JpaSpecificationExecutor<Student>, JpaRepository<Student, Integer> {
}
