package com.example.first.utility;//package com.example.first.utility;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "ratings")
//public class Rating {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Double value;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Courses courses;
//
//    public Rating() {}
//
//    public Rating(Double value, Courses courses) {
//        this.value = value;
//        this.courses = courses;
//    }
//
//    @Override
//    public String toString() {
//        return "Rating{" +
//                "id=" + id +
//                ", value=" + value +
//                ", courses=" + courses +
//                '}';
//    }
//}


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Rating(Double value, Courses courses) {}

    public Rating(Double value, Courses courses, User user) {
        this.value = value;
        this.courses = courses;
        this.user=user;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", courses=" + courses +
                ", User=" + user +
                '}';
    }
}
