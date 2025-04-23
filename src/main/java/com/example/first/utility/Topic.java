//package com.example.first.utility;
//
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
//    public Topic(String topicId, String name, Courses courses) {
//        this.topicId = topicId;
//        this.name = name;
//        this.courses = courses;
//    }
//
//    public Topic() {}
//
//}

//package com.example.first.utility;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
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
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String topicId;
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    @JsonBackReference
//    private Courses courses;
//
//    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Resource> resources;
//
//    public Topic(String topicId, String name, Courses courses) {
//        this.topicId = topicId;
//        this.name = name;
//        this.courses = courses;
//    }
//
//    public Topic() {}
//}


package com.example.first.utility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
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
    @JsonBackReference
    private Courses courses;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resource> resources;

    public Topic(String topicId, String name, Courses courses) {
        this.topicId = topicId;
        this.name = name;
        this.courses = courses;
    }

    public Topic() {}
}

