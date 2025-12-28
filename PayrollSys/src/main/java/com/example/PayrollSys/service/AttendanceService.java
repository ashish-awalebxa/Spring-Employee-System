package com.example.PayrollSys.service;

import com.example.PayrollSys.entity.Attendance;
import com.example.PayrollSys.entity.Employee;
import com.example.PayrollSys.repository.AttendanceRepository;
import com.example.PayrollSys.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    public Attendance markAttendance(Long empId, Attendance attendance) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (attendanceRepository.existsByEmployeeAndDate(employee, attendance.getDate())) {
            throw new RuntimeException("Attendance already marked for this date");
        }

        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }
}
