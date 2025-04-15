package com.example.first.controller;

import com.example.first.dto.ProgressUpdateRequest;
import com.example.first.service.InteractionsService;
import com.example.first.utility.Interactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private InteractionsService interactionsService;

    // ✅ 1. Start a course
    // Example: http://localhost:8080/api/progress/start?email=bride@gmail.com&courseId=1
    @GetMapping("/start")
    public ResponseEntity<Interactions> startCourse(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions started = interactionsService.startCourse(email, courseId);
        return ResponseEntity.ok(started);
    }

    // ✅ 2. Update progress
    // Example: http://localhost:8080/api/progress/update?emailAddress=bride@gmail.com&courseId=1&progressPercentage=50.0
    @PutMapping("/update")
    public ResponseEntity<Interactions> updateProgress(@RequestBody ProgressUpdateRequest request) {
        Interactions updated = interactionsService.updateProgress(
                request.getEmailAddress(),
                request.getCourseId(),
                request.getProgressPercentage()
        );
        return ResponseEntity.ok(updated);
    }


    // ✅ 3. Mark course as completed
    // Example: http://localhost:8080/api/progress/complete?email=bride@gmail.com&courseId=1
    @GetMapping("/complete")
    public ResponseEntity<Interactions> completeCourse(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions completed = interactionsService.completeCourse(email, courseId);
        return ResponseEntity.ok(completed);
    }

    // ✅ 4. Get all progress for a user
    // Example: http://localhost:8080/api/progress/all?email=bride@gmail.com
    @GetMapping("/all")
    public ResponseEntity<Optional<Interactions>> getAllProgress(
            @RequestParam String email) {

        Optional<Interactions> progress = interactionsService.getAllByUser(email);
        return ResponseEntity.ok(progress);
    }

    // ✅ 5. Get specific progress for a user and course
    // Example: http://localhost:8080/api/progress/one?email=bride@gmail.com&courseId=1
    @GetMapping("/one")
    public ResponseEntity<Interactions> getSpecificProgress(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions interaction = interactionsService.getInteraction(email, courseId);
        return ResponseEntity.ok(interaction);
    }
}
