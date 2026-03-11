package com.ironhack.ironhomework.service;

import com.ironhack.ironhomework.model.Teacher;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teachers.stream()
                .filter(t -> t.getTeacherId().equalsIgnoreCase(id))
                .findFirst();
    }

    public double getTotalSalaries() {
        return teachers.stream().mapToDouble(Teacher::getSalary).sum();
    }
}