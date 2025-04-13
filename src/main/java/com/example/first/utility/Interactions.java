package com.example.first.utility;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

//@Entity
//@Data
//@Table(name = "interactions")
//public class Interactions {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    public long id;
//    public User user;
//    public String enrollment_status;
//    public Courses courses;
//
//    @Override
//    public String toString() {
//        return "Interactions{" +
//                "id=" + id +
//                ", user=" + user +
//                ", enrollment_status='" + enrollment_status + '\'' +
//                ", courses=" + courses +
//                '}';
//    }
//}

@Entity
@Data
@Table(name = "interactions")
public class Interactions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String enrollment_status;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    @Column(name = "progress_percentage")
    private Double progressPercentage;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "last_accessed")
    private LocalDateTime lastAccessed;

    @Column(name = "is_completed")
    private Boolean isCompleted;
}
