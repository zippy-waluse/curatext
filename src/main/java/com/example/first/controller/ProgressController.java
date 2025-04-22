//package com.example.first.controller;
//
//import com.example.first.dto.ProgressUpdateRequest;
//import com.example.first.service.InteractionsService;
//import com.example.first.utility.Interactions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/progress")
//public class ProgressController {
//
//    @Autowired
//    private InteractionsService interactionsService;
//
//    @GetMapping("/start")
//    public ResponseEntity<Interactions> startCourse(
//            @RequestParam String email,
//            @RequestParam Long courseId) {
//
//        Interactions started = interactionsService.startCourse(email, courseId);
//        return ResponseEntity.ok(started);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<Interactions> updateProgress(@RequestBody ProgressUpdateRequest request) {
//        Interactions updated = interactionsService.updateProgress(
//                request.getEmailAddress(),
//                request.getCourseId(),
//                request.getProgressPercentage()
//        );
//        return ResponseEntity.ok(updated);
//    }
//
//
//    @GetMapping("/complete")
//    public ResponseEntity<Interactions> completeCourse(
//            @RequestParam String email,
//            @RequestParam Long courseId) {
//
//        Interactions completed = interactionsService.completeCourse(email, courseId);
//        return ResponseEntity.ok(completed);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Interactions>> getAllProgress() {
//
//        List<Interactions> progress = interactionsService.getAllInteractions();
//        return ResponseEntity.ok(progress);
//    }
//
//    @GetMapping("/one")
//    public ResponseEntity<Interactions> getSpecificProgress(
//            @RequestParam String email,
//            @RequestParam Long courseId) {
//
//        Interactions interaction = interactionsService.getInteraction(email, courseId);
//        return ResponseEntity.ok(interaction);
//    }
//}


package com.example.first.controller;

import com.example.first.dto.ProgressUpdateRequest;
import com.example.first.service.InteractionsService;
import com.example.first.utility.Interactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private InteractionsService interactionsService;

    @GetMapping("/start")
    public ResponseEntity<Interactions> startCourse(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions started = interactionsService.startCourse(email, courseId);
        return ResponseEntity.ok(started);
    }

    @PutMapping("/update")
    public ResponseEntity<Interactions> updateProgress(@RequestBody ProgressUpdateRequest request) {
        Interactions updated = interactionsService.updateProgress(
                request.getEmailAddress(),
                request.getCourseId(),
                request.getProgressPercentage()
        );
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/complete")
    public ResponseEntity<Interactions> completeCourse(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions completed = interactionsService.completeCourse(email, courseId);
        return ResponseEntity.ok(completed);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interactions>> getAllProgress() {
        List<Interactions> progress = interactionsService.getAllInteractions();
        return ResponseEntity.ok(progress);
    }

    @GetMapping("/one")
    public ResponseEntity<Interactions> getSpecificProgress(
            @RequestParam String email,
            @RequestParam Long courseId) {

        Interactions interaction = interactionsService.getInteraction(email, courseId);
        return ResponseEntity.ok(interaction);
    }

     @GetMapping("/ratings")
    public ResponseEntity<List<ProgressUpdateRequest>> getAllRatings() {
        List<ProgressUpdateRequest> ratings = interactionsService.getAllUserCourseRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/all-ratings")
    public ResponseEntity<List<Interactions>> getRatings() {
        List<Interactions> ratings = interactionsService.getAllInteractions();
        return ResponseEntity.ok(ratings);
    }
}
