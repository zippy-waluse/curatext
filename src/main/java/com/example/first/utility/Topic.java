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
//    private Course course;
//
//    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Resource> resources;
//
//    public Topic(String c1T1, String s, Course c1) {
//
//    }
//
//    // Constructors, Getters, and Setters
//}
//


package com.example.first.utility;

import jakarta.persistence.*;
import java.util.List;

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
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources;

    // ✅ Proper Constructor
    public Topic(String topicId, String name, Course course) {
        this.topicId = topicId;
        this.name = name;
        this.course = course;
    }

    // ✅ Default Constructor (Required by JPA)
    public Topic() {}

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
