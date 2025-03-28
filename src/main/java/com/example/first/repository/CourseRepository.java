package com.example.first.repository;

import com.example.first.utility.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // ✅ Required annotation
public interface CourseRepository extends JpaRepository<Course, Long> {
    // JpaRepository provides built-in methods for CRUD operations
}
