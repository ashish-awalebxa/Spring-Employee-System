package com.example.PayrollSys.controller;

import com.example.PayrollSys.entity.Interview;
import com.example.PayrollSys.service.InterviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("/{empId}")
    public Interview addInterview(
            @PathVariable Long empId,
            @RequestBody Interview interview) {
        return interviewService.addInterview(empId, interview);
    }
}
