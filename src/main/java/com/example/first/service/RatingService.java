package com.example.first.service;

import com.example.first.repository.RatingRepository;
import com.example.first.utility.Course;
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
        Course course = courseService.getCourseById(courseId);
        Rating rating = new Rating(value, course);
        ratingRepository.save(rating);

        updateCourseRating(course);
        return rating;
    }

    public void updateCourseRating(Course course) {
        List<Rating> ratings = course.getRatings();
        double average = ratings.stream().mapToDouble(Rating::getValue).average().orElse(0.0);
        course.setRating(average);
        courseService.updateCourse(course);
    }
}
