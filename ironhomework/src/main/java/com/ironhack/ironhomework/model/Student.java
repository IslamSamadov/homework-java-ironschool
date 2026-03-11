package com.ironhack.ironhomework.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Student {
    private static int idCounter = 1;
    private String studentId;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Email
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        this.studentId = "S-" + idCounter++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = null;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public Course getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setCourse(Course course) { this.course = course; }
}
