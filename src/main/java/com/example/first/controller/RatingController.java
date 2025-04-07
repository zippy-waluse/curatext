//package com.example.first.controller;
//
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

package com.example.first.controller;

import com.example.first.service.RatingService;
import com.example.first.utility.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/{courseId}")
    public Rating addRating(@PathVariable Long courseId, @RequestParam Double value) {
        return ratingService.addRating(courseId, value);
    }
}

