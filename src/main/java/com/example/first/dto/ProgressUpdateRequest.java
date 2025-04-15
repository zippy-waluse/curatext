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
}
