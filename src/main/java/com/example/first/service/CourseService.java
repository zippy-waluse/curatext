//package com.example.first.service;
//
//import com.example.first.repository.CourseRepository;
//import com.example.first.utility.Courses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.List;
//
//@Service
//public class CourseService {
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Transactional
//    public void saveAllCourses(List<Courses> courses) {
//        courseRepository.saveAll(courses);
//    }
//
//    public List<Courses> getAllCourses() {
//        return courseRepository.findAll();
//    }
//}



package com.example.first.service;

import com.example.first.repository.CourseRepository;
import com.example.first.utility.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void saveAllCourses(List<Courses> courses) {
        courseRepository.saveAll(courses);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Courses getCourseById(Long id) {
        Optional<Courses> courses = courseRepository.findById(id);
        return courses.orElseThrow(() -> new RuntimeException("Courses not found"));
    }

    public void updateCourse(Courses courses) {
        courseRepository.save(courses);
    }
}
