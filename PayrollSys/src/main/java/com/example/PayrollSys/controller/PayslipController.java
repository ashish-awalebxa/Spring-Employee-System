package com.example.PayrollSys.controller;

import com.example.PayrollSys.dto.PayslipResponse;
import com.example.PayrollSys.entity.Employee;
import com.example.PayrollSys.repository.AttendanceRepository;
import com.example.PayrollSys.repository.EmployeeRepository;
import com.example.PayrollSys.repository.InterviewRepository;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequestMapping("/payslip")
public class PayslipController {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final InterviewRepository interviewRepository;

    public PayslipController(EmployeeRepository employeeRepository,
                             AttendanceRepository attendanceRepository,
                             InterviewRepository interviewRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
        this.interviewRepository = interviewRepository;
    }

    @GetMapping("/{empId}")
    public PayslipResponse generatePayslip(
            @PathVariable Long empId,
            @RequestParam String month) {

        YearMonth yearMonth = YearMonth.parse(month);

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        long presentDays =
                attendanceRepository.countByEmployeeAndDateBetweenAndPresentTrue(
                        employee,
                        yearMonth.atDay(1),
                        yearMonth.atEndOfMonth()
                );

        int perDaySalary = employee.getDesignation().getPerDaySalary();

        int interviewIncentives =
                interviewRepository.findByEmployeeAndDateBetween(
                                employee,
                                yearMonth.atDay(1),
                                yearMonth.atEndOfMonth()
                        )
                        .stream()
                        .mapToInt(i -> i.getType().getIncentive())
                        .sum();

        int totalSalary =
                (int) presentDays * perDaySalary + interviewIncentives;

        return new PayslipResponse(
                employee.getId(),
                employee.getName(),
                employee.getDesignation().name(),
                yearMonth.toString(),
                presentDays,
                perDaySalary,
                interviewIncentives,
                totalSalary
        );
    }
}
