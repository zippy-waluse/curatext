//////package com.example.first.utility;
//////
//////import jakarta.persistence.*;
//////import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//////
//////import java.util.List;
//////
//////@Entity
//////@Table(name = "courses")
//////public class Course {
//////    @Id
//////    @GeneratedValue(strategy = GenerationType. IDENTITY)
//////    private Long id;
//////
//////    private String courseId;
//////    private String name;
//////    private String description;
//////
//////    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
//////    private List<KafkaProperties.Retry.Topic> topics;
//////
//////    public Course(String c1, String businessCommunication, String s) {
//////
//////    }
//////
//////    // Constructors, Getters, and Setters
//////}
//////
////
////
////
////package com.example.first.utility;
////
////import jakarta.persistence.*;
////import java.util.List;
////
////@Entity
////@Table(name = "courses")
////public class Course {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String courseId;
////    private String name;
////    private String description;
////
////    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<Topic> topics;  // ✅ FIXED: Correct Topic import
////
////    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<Rating> ratings;
////
////
////    // ✅ Proper Constructor
////    public Course(String courseId, String name, String description) {
////        this.courseId = courseId;
////        this.name = name;
////        this.description = description;
////    }
////
////    // ✅ Default Constructor (Required by JPA)
////    public Course() {}
////
////    // ✅ Getters and Setters
////    public Long getId() {
////        return id;
////    }
////
////    public String getCourseId() {
////        return courseId;
////    }
////
////    public void setCourseId(String courseId) {
////        this.courseId = courseId;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public List<Topic> getTopics() {
////        return topics;
////    }
////
////    public void setTopics(List<Topic> topics) {
////        this.topics = topics;
////    }
////}
//
//
//
//package com.example.first.utility;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//
//import java.util.List;
//
//@Getter
//@Entity
//@Table(name = "courses")
//public class Course {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String courseId;
//    private String name;
//    private String description;
//
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Topic> topics;
//
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Rating> ratings;
//
//    private double rating;
//
//    public Course(String courseId, String name, String description) {
//        this.courseId = courseId;
//        this.name = name;
//        this.description = description;
//    }
//
//    public Course() {}
//
//    public void setCourseId(String courseId) { this.courseId = courseId; }
//
//    public void setName(String name) { this.name = name; }
//
//    public void setDescription(String description) { this.description = description; }
//
//    public void setTopics(List<Topic> topics) { this.topics = topics; }
//
//    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
//
//    public void setRating(double rating) { this.rating = rating; }
//}



package com.example.first.utility;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> topics;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings;

    // Changed from primitive double to wrapper Double to allow null values
    private Double rating;

    public Course(String courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
    }

    public Course() {}

    public void setCourseId(String courseId) { this.courseId = courseId; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setTopics(List<Topic> topics) { this.topics = topics; }

    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }

    public void setRating(Double rating) { this.rating = rating; }
}