package com.example.first.controller;

import com.example.first.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import com.example.first.service.RatingService;
//import com.example.first.utility.Rating;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/ratings")
//public class RatingController {
//    @Autowired
//    private RatingService ratingService;
//
//    @PostMapping("/{courseId}")
//    public Rating addRating(@PathVariable Long courseId, @RequestParam Double value) {
//        return ratingService.addRating(courseId, value);
//    }
//}
//


//
//@RestController
//@RequestMapping("/api/progress")
//public class RatingController {
//
//    @Autowired
//    private RatingRepository ratingRepository;
//
//    @GetMapping("/ratings")
//    public List<Map<String, Object>> getRatings() {
//        return ratingRepository.findAll().stream().map(rating -> {
//            Map<String, Object> map = new HashMap<>();
//            map.put("student_id", rating.getUser().getId());
//            map.put("course_id", rating.getCourses().getId());
//            map.put("rating", rating.getValue());
//            return map;
//        }).collect(Collectors.toList());
//    }
//}





@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("")
    public List<Map<String, Object>> getRatings() {
        return ratingRepository.findAll().stream().map(rating -> {
            Map<String, Object> map = new HashMap<>();
            map.put("student_id", rating.getUser().getId());
            map.put("course_id", rating.getCourses().getId());
            map.put("rating", rating.getValue());
            return map;
        }).collect(Collectors.toList());
    }
}

