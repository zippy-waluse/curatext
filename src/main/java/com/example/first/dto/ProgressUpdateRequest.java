//package com.example.first.dto;
//
//public class ProgressUpdateRequest {
//    private String emailAddress;
//    private Long courseId;
//    private Double progressPercentage;
//
//    // Getters and Setters
//}
package com.example.first.dto;

import lombok.Data;

@Data
public class ProgressUpdateRequest {
    private String emailAddress;
    private Long courseId;
    private Double progressPercentage;
    private Long userId;
    private Long course_id;
    private Double rating;

    public ProgressUpdateRequest(Long userId, Long courseId, Double rating) {
        this.userId = userId;
        this.courseId = courseId;
        this.rating = rating;
    }
}
