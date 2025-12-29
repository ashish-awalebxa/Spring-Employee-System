package com.example.PayrollSys.enums;

public enum InterviewType {

    R1(1000),
    R2(2000),
    R3(3000);

    private final int incentive;

    InterviewType(int incentive) {
        this.incentive = incentive;
    }

    public int getIncentive() {
        return incentive;
    }
}
