package com.example.PayrollSys.repository;

import com.example.PayrollSys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}