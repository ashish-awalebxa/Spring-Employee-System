package com.example.PayrollSys.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private boolean isPresent;


    @ManyToMany
    @JoinColumn(name = "emp_id",nullable = false)
    private Employee employee;

    public Attendance(){}

    public Attendance(LocalDate date, boolean isPresent, Employee employee) {
        this.date = date;
        this.isPresent = isPresent;
        this.employee = employee;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
