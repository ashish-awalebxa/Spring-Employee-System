package com.example.PayrollSys.repository;

import com.example.PayrollSys.entity.Attendance;
import com.example.PayrollSys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    long countByEmployeeAndDateBetweenAndIsPresentTrue(
      Employee employee,
      LocalDate startdate,
      LocalDate endDate
    );
}
