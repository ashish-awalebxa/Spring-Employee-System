package com.example.PayrollSys.controller;


import com.example.PayrollSys.entity.Attendance;
import com.example.PayrollSys.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @PostMapping("/{empId}")
    public Attendance markAttendance(
            @PathVariable Long empId,
            @RequestBody Attendance attendance
    ){
        return attendanceService.markAttendance(empId,attendance);
    }
}
