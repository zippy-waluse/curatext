package com.example.first.service;

import com.example.first.repository.CourseRepository;
import com.example.first.utility.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void saveAllCourses(List<Course> courses) {
        courseRepository.saveAll(courses);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
