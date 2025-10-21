package io.github.anujkumar.recruitment_management_system.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // primary key

    private String title;
    private String description;

    private LocalDateTime postedOn = LocalDateTime.now(); // default to current datetime

    private int totalApplication;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key column in Job table
    @ToString.Exclude  // avoid infinite recursion in toString
    @JsonBackReference
    private User postedBy;
}
