//
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
//import java.util.List;
//import java.util.Optional;
//
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
//
//    public Interactions completeCourse(String email, Long courseId) {
//        Interactions interaction = interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//
//        interaction.setIsCompleted(true);
//        interaction.setEnrollment_status("completed");
//        interaction.setLastAccessed(LocalDateTime.now());
//
//        return interactionsRepository.save(interaction);
//    }
//
//    // ✅ Update course progress
//    public Interactions updateProgress(String email, Long courseId, double progress) {
//        Interactions interaction = interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//
//        interaction.setProgressPercentage(progress);
//        interaction.setLastAccessed(LocalDateTime.now());
//
//        return interactionsRepository.save(interaction);
//    }
//
//    public Optional<Interactions> getAllByUser(String email) {
//        return interactionsRepository.findInteractionsByUserEmailAddress(email);
//    }
//
//    public Interactions getInteraction(String email, Long courseId) {
//        return interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//    }
//    public List<Interactions> getAllInteractions(){
//        return interactionsRepository.findAll();
//    }
//}
//


//package com.example.first.service;
//
//import com.example.first.dto.ProgressUpdateRequest;
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
//import java.util.List;
//import java.util.Optional;
//
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
//
//    public Interactions completeCourse(String email, Long courseId) {
//        Interactions interaction = interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//
//        interaction.setIsCompleted(true);
//        interaction.setEnrollment_status("completed");
//        interaction.setLastAccessed(LocalDateTime.now());
//
//        return interactionsRepository.save(interaction);
//    }
//
//    public Interactions updateProgress(String email, Long courseId, double progress) {
//        Interactions interaction = interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//
//        interaction.setProgressPercentage(progress);
//        interaction.setLastAccessed(LocalDateTime.now());
//
//        return interactionsRepository.save(interaction);
//    }
//
//    public Optional<Interactions> getAllByUser(String email) {
//        return interactionsRepository.findInteractionsByUserEmailAddress(email);
//    }
//
//    public Interactions getInteraction(String email, Long courseId) {
//        return interactionsRepository
//                .findByUserEmailAddressAndCoursesId(email, courseId)
//                .orElseThrow(() -> new RuntimeException("Interaction not found"));
//    }
//
//    public List<Interactions> getAllInteractions() {
//        return interactionsRepository.findAll();
//    }
//
//    public List<ProgressUpdateRequest> getAllUserCourseRatings() {
//        List<Interactions> allInteractions = interactionsRepository.findAll();
//        return allInteractions.stream()
//                .map(interaction -> new ProgressUpdateRequest(
//                        interaction.getUser().getId(),
//                        interaction.getCourses().getId(),
//                        interaction.getProgressPercentage()
//                ))
//                .toList();
//    }
//}
//

package com.example.first.service;

import com.example.first.dto.ProgressUpdateRequest;
import com.example.first.dto.RatingDTO;
import com.example.first.repository.CourseRepository;
import com.example.first.repository.InteractionsRepository;
import com.example.first.repository.UserRepository;
import com.example.first.utility.Courses;
import com.example.first.utility.Interactions;
import com.example.first.utility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InteractionsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InteractionsRepository interactionsRepository;

    public Interactions startCourse(String email, Long courseId) {
        Optional<User> user = userRepository.findByEmailAddress(email);

        Courses course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Interactions interaction = new Interactions();
        interaction.setUser(null);
        interaction.setCourses(course);
        interaction.setEnrollment_status("started");
        interaction.setProgressPercentage(0.0);
        interaction.setStartDate(LocalDateTime.now());
        interaction.setLastAccessed(LocalDateTime.now());
        interaction.setIsCompleted(false);


        return interactionsRepository.save(interaction);
    }

    public Interactions completeCourse(String email, Long courseId) {
        Interactions interaction = interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));

        interaction.setIsCompleted(true);
        interaction.setEnrollment_status("completed");
        interaction.setLastAccessed(LocalDateTime.now());

        return interactionsRepository.save(interaction);
    }

    public Interactions updateProgress(String email, Long courseId, double progress) {
        Interactions interaction = interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));

        interaction.setProgressPercentage(progress);
        interaction.setLastAccessed(LocalDateTime.now());

        return interactionsRepository.save(interaction);
    }

    public Optional<Interactions> getAllByUser(String email) {
        return interactionsRepository.findInteractionsByUserEmailAddress(email);
    }

    public Interactions getInteraction(String email, Long courseId) {
        return interactionsRepository
                .findByUserEmailAddressAndCoursesId(email, courseId)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));
    }

    public List<Interactions> getAllInteractions() {
        return interactionsRepository.findAll();
    }

    public List<ProgressUpdateRequest> getAllUserCourseRatings() {
        return interactionsRepository.findAll().stream()
                .filter(i -> i.getUser() != null && i.getCourses() != null)
                .map(i -> new ProgressUpdateRequest(
                        i.getUser().getId(),
                        i.getCourses().getId(),
                        i.getProgressPercentage()
                ))
                .toList();
    }


}
