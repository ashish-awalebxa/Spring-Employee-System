package com.example.PayrollSys.repository;

import com.example.PayrollSys.entity.Attendance;
import com.example.PayrollSys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    long countByEmployeeAndDateBetweenAndPresentTrue(
            Employee employee,
            LocalDate start,
            LocalDate end
    );

    boolean existsByEmployeeAndDate(Employee employee, LocalDate date);
}
