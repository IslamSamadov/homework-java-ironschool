package com.ironhack.ironhomework.service;

import com.ironhack.ironhomework.model.Course;
import com.ironhack.ironhomework.model.Student;
import com.ironhack.ironhomework.model.Teacher;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();
    private final TeacherService teacherService;
    private final StudentService studentService;

    public CourseService(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public Optional<Course> getCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getCourseId().equalsIgnoreCase(id))
                .findFirst();
    }

    public void updateCoursePrice(String id, double newPrice) {
        Course course = getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Kurs tapılmadı"));
        course.setPrice(newPrice);
    }

    public void deleteCourse(String id) {
        courses.removeIf(c -> c.getCourseId().equalsIgnoreCase(id));
    }


    public void enrollStudent(String studentId, String courseId) {
        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Tələbə tapılmadı"));
        Course course = getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Kurs tapılmadı"));

        student.setCourse(course);
        course.updateMoneyEarned(course.getPrice());
    }

    public void assignTeacher(String teacherId, String courseId) {
        Teacher teacher = teacherService.getTeacherById(teacherId)
                .orElseThrow(() -> new RuntimeException("Müəllim tapılmadı"));
        Course course = getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Kurs tapılmadı"));

        course.setTeacher(teacher);
    }


    public double getProfit() {
        double totalEarned = courses.stream().mapToDouble(Course::getMoney_earned).sum();
        double totalSalaries = teacherService.getTotalSalaries();
        return totalEarned - totalSalaries;
    }
}