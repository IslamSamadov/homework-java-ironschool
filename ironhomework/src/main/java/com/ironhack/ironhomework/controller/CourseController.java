package com.ironhack.ironhomework.controller;

import com.ironhack.ironhomework.model.Course;
import com.ironhack.ironhomework.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return course;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Course not found: " + id));
    }

    @PatchMapping("/{id}/price")
    public String updatePrice(@PathVariable String id, @RequestParam double newPrice) {
        courseService.updateCoursePrice(id, newPrice);
        return "Course price updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return "Course deleted: " + id;
    }

    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam String studentId, @RequestParam String courseId) {
        courseService.enrollStudent(studentId, courseId);
        return "Student accepted to course successfully.";
    }

    @PostMapping("/assign")
    public String assignTeacher(@RequestParam String teacherId, @RequestParam String courseId) {
        courseService.assignTeacher(teacherId, courseId);
        return "Teacher was accepted to course successfully.";
    }

    @GetMapping("/profit")
    public String showProfit() {
        double profit = courseService.getProfit();
        return "School whole profit: " + profit;
    }
}