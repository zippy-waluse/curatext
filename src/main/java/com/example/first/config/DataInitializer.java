package com.example.first.config;

import com.example.first.service.CourseService;
import com.example.first.utility.Courses;
import com.example.first.utility.Resource;
import com.example.first.utility.Topic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(CourseService courseService) {
        return args -> {
            Courses c1 = new Courses("c1", "Business Communication", "Fundamentals of workplace communication...");
            Topic t1 = new Topic("c1_t1", "Verbal & Non-Verbal Communication", c1);
            Resource r1 = new Resource("c1_r1", "Mastering Business Communication", "https://example.com/business-communication.pdf", "PDF", t1);

            t1.setResources(List.of(r1));
            c1.setTopics(List.of(t1));

            courseService.saveAllCourses(List.of(c1));
        };
    }
}

