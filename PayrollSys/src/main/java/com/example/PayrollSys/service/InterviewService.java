package com.example.PayrollSys.service;

import com.example.PayrollSys.entity.Employee;
import com.example.PayrollSys.entity.Interview;
import com.example.PayrollSys.repository.EmployeeRepository;
import com.example.PayrollSys.repository.InterviewRepository;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final EmployeeRepository employeeRepository;

    public InterviewService(InterviewRepository interviewRepository,
                            EmployeeRepository employeeRepository) {
        this.interviewRepository = interviewRepository;
        this.employeeRepository = employeeRepository;
    }

    public Interview addInterview(Long empId, Interview interview) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        interview.setEmployee(employee);
        return interviewRepository.save(interview);
    }
}
