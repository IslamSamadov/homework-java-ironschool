package com.ironhack.ironhomework.controller;

import com.ironhack.ironhomework.model.Teacher;
import com.ironhack.ironhomework.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return teacher;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable String id) {
        return teacherService.getTeacherById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found: " + id));
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, @Valid @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return "Teacher deleted successfully: " + id;
    }
}