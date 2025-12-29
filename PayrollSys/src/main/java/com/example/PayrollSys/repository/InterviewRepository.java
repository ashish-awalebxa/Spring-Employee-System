package com.example.PayrollSys.repository;

import com.example.PayrollSys.entity.Employee;
import com.example.PayrollSys.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findByEmployeeAndDateBetween(
            Employee employee,
            LocalDate start,
            LocalDate end
    );
}
