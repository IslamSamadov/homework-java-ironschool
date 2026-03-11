package com.ironhack.ironhomework.service;

import com.ironhack.ironhomework.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> getStudentById(String id) {
        return students.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Student updateStudent(String id, Student updatedData) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Tələbə tapılmadı: " + id));
        student.setName(updatedData.getName());
        student.setAddress(updatedData.getAddress());
        student.setEmail(updatedData.getEmail());
        return student;
    }

    public void updateAddress(String id, String newAddress) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Tələbə tapılmadı"));
        student.setAddress(newAddress);
    }

    public void deleteStudent(String id) {
        students.removeIf(s -> s.getStudentId().equalsIgnoreCase(id));
    }
}