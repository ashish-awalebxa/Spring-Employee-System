package com.example.PayrollSys.dto;

public class PayslipResponse {

    private Long employeeId;
    private String employeeName;
    private String designation;
    private String month;
    private long presentDays;
    private int perDaySalary;
    private int interviewIncentives;
    private int totalSalary;

    public PayslipResponse(Long employeeId,
                           String employeeName,
                           String designation,
                           String month,
                           long presentDays,
                           int perDaySalary,
                           int interviewIncentives,
                           int totalSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.month = month;
        this.presentDays = presentDays;
        this.perDaySalary = perDaySalary;
        this.interviewIncentives = interviewIncentives;
        this.totalSalary = totalSalary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getMonth() {
        return month;
    }

    public long getPresentDays() {
        return presentDays;
    }

    public int getPerDaySalary() {
        return perDaySalary;
    }

    public int getInterviewIncentives() {
        return interviewIncentives;
    }

    public int getTotalSalary() {
        return totalSalary;
    }
}
