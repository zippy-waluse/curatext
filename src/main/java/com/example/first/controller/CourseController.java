package com.example.first.controller;

import com.example.first.service.CourseService;
import com.example.first.utility.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String addCourses(@RequestBody List<Course> courses) {
        courseService.saveAllCourses(courses);
        return "Courses added successfully!";
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }
}
