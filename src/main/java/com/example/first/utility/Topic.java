//package com.example.first.utility;
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "topics")
//public class Topic {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String topicId;
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Courses courses;
//
//    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Resource> resources;
//
//    public Topic(String c1T1, String s, Courses c1) {
//
//    }
//
//    // Constructors, Getters, and Setters
//}
//




package com.example.first.utility;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources;

    public Topic(String topicId, String name, Courses courses) {
        this.topicId = topicId;
        this.name = name;
        this.courses = courses;
    }

    public Topic() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
//package com.example.first.utility;

//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "topics")
//public class Topic {
//    // Getters and Setters
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Courses courses;
//
//    // Constructors
//    public Topic() {}
//
//    public Topic(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
//
//    public Topic(String c1T1, String s, Courses c1) {
//
//    }
//
//    public void setResources(List<Resource> r1) {
//
//    }
//}

