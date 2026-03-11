package com.ironhack.ironhomework.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Course {
    private static int idCounter = 1;
    private String courseId;
    @NotBlank
    private String name;
    @Min(0)
    private double price;
    @Min(0)
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.courseId = "C-" + idCounter++;
        this.name = name;
        this.price = price;
        this.money_earned = 0.0;
        this.teacher = null;
    }

    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getMoney_earned() { return money_earned; }
    public Teacher getTeacher() { return teacher; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void updateMoneyEarned(double amount) {
        this.money_earned += amount;
    }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
}