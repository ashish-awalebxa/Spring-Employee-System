package com.example.PayrollSys.enums;

public enum Designation {

    SE(1000),
    SSE(2000),
    MANAGER(3000);

    private final int perDaySalary;

    Designation(int perDaySalary) {
        this.perDaySalary = perDaySalary;
    }

    public int getPerDaySalary() {
        return perDaySalary;
    }
}
