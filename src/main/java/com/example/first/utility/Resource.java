package com.example.first.utility;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceId;
    private String title;
    private String contentUrl;
    private String type;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Resource(String c1R1, String masteringBusinessCommunication, String url, String pdf, Topic t1) {

    }

    // Constructors, Getters, and Setters
}

