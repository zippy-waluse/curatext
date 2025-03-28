package com.example.first.utility;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;  // Rating value (e.g., 1.0 - 5.0)

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Rating() {}

    public Rating(Double value, Course course) {
        this.value = value;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
