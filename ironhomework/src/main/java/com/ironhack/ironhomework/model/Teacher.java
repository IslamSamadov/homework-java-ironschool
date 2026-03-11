package com.ironhack.ironhomework.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Teacher {
    private static int idCounter = 1;
    private String teacherId;
    @NotBlank
    private String name;
    @Min(0)
    private double salary;

    public Teacher(String name, double salary) {
        this.teacherId = "T-" + idCounter++;
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
