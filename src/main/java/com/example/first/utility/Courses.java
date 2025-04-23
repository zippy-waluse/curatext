//package com.example.first.utility;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "courses")
//@RequiredArgsConstructor
//@AllArgsConstructor
//public class Courses implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String courseId;
//    private String name;
//
//    @Column(name = "description", length = 25_000)
//    private String description;
//
//    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Topic> topics;
//
//    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Rating> ratings;
//
//    private Double rating;
//
//    public Courses(String courseId, String name, String description) {
//        this.courseId = courseId;
//        this.name = name;
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Courses{" +
//                "id=" + id +
//                ", courseId='" + courseId + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", rating=" + rating +
//                '}';
//    }
//}

package com.example.first.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "courses")
@RequiredArgsConstructor
@AllArgsConstructor
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseId;
    private String name;

    @Column(name = "description", length = 25_000)
    private String description;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore  // Prevent topics from being serialized within Course
    private List<Topic> topics;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings;

    private Double rating;

    public Courses(String courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ratings=" + ratings +
                ", rating=" + rating +
                '}';
    }
}

