package com.example.first.service;

import com.example.first.repository.RatingRepository;
import com.example.first.utility.Courses;
import com.example.first.utility.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CourseService courseService;

    public Rating addRating(Long courseId, Double value) {
        Courses courses = courseService.getCourseById(courseId);
        Rating rating = new Rating(value, courses);
        ratingRepository.save(rating);

        updateCourseRating(courses);
        return rating;
    }

    public void updateCourseRating(Courses courses) {
        List<Rating> ratings = courses.getRatings();
        double average = ratings.stream().mapToDouble(Rating::getValue).average().orElse(0.0);
        courses.setRating(average);
        courseService.updateCourse(courses);
    }
}
