package com.example.first.utility;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    public Rating() {}

    public Rating(Double value, Courses courses) {
        this.value = value;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", courses=" + courses +
                '}';
    }
}
