package com.ironhack.ironhomework.controller;

import com.ironhack.ironhomework.model.Student;
import com.ironhack.ironhomework.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @Valid @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @PatchMapping("/{id}/address")
    public String updateAddress(@PathVariable String id, @RequestBody String newAddress) {
        studentService.updateAddress(id, newAddress);
        return "Students address updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully: " + id;
    }
}