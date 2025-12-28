package com.example.PayrollSys.service;

import com.example.PayrollSys.entity.Employee;
import com.example.PayrollSys.repository.AttendanceRepository;
import com.example.PayrollSys.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;

    public SalaryService(EmployeeRepository employeeRepository,
                         AttendanceRepository attendanceRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public int calculateMonthlySalary(Long empId, YearMonth month) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        long presentDays =
                attendanceRepository.countByEmployeeAndDateBetweenAndPresentTrue(
                        employee,
                        month.atDay(1),
                        month.atEndOfMonth()
                );

        return (int) presentDays * employee.getDesignation().getPerDaySalary();
    }
}
