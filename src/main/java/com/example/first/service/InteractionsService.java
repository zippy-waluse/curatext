//package com.example.first.service;
//
//import com.example.first.repository.CourseRepository;
//import com.example.first.repository.InteractionsRepository;
//import com.example.first.repository.UserRepository;
//import com.example.first.utility.Courses;
//import com.example.first.utility.Interactions;
//import com.example.first.utility.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//@Service
//public class InteractionsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private InteractionsRepository interactionsRepository;
//
//    // Start a course for a user
//    public Interactions startCourse(String email, Long courseId) {
//        User user = userRepository.findByEmailAddress(email);
//
//        Courses course = courseRepository.findById(courseId)
//                .orElseThrow(() -> new RuntimeException("Course not found"));
//
//        Interactions interaction = new Interactions();
//        interaction.setUser(user);
//        interaction.setCourses(course);
//        interaction.setEnrollment_status("started");
//        interaction.setProgressPercentage(0.0);
//        interaction.setStartDate(LocalDateTime.now());
//        interaction.setLastAccessed(LocalDateTime.now());
//        interaction.setIsCompleted(false);
//
//        return interactionsRepository.save(interaction);
//    }
//}


package com.example.first.service;

import com.example.first.repository.CourseRepository;
import com.example.first.repository.InteractionsRepository;
import com.example.first.repository.UserRepository;
import com.example.first.utility.Courses;
import com.example.first.utility.Interactions;
import com.example.first.utility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InteractionsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InteractionsRepository interactionsRepository;

    // ✅ Start a course for a user
    public Interactions startCourse(String email, Long courseId) {
        User user = userRepository.findByEmailAddress(email);

        Courses course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Interactions interaction = new Interactions();
        interaction.setUser(user);
        interaction.setCourses(course);
        interaction.setEnrollment_status("started");
        interaction.setProgressPercentage(0.0);
        interaction.setStartDate(LocalDateTime.now());
        interaction.setLastAccessed(LocalDateTime.now());
        interaction.setIsCompleted(false);

        return interactionsRepository.save(interaction);
    }

    // ✅ Mark a course as completed
    public Interactions completeCourse(String email, Long courseId) {
        Interactions interaction = interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));

        interaction.setIsCompleted(true);
        interaction.setEnrollment_status("completed");
        interaction.setLastAccessed(LocalDateTime.now());

        return interactionsRepository.save(interaction);
    }

    // ✅ Update course progress
    public Interactions updateProgress(String email, Long courseId, double progress) {
        Interactions interaction = interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));

        interaction.setProgressPercentage(progress);
        interaction.setLastAccessed(LocalDateTime.now());

        return interactionsRepository.save(interaction);
    }

    // ✅ Get all progress for a user
    public Optional<Interactions> getAllByUser(String email) {
        return interactionsRepository.findInteractionsByUserEmailAddress(email);
    }

    // ✅ Get a specific interaction
    public Interactions getInteraction(String email, Long courseId) {
        return interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));
    }
}

