package io.github.anujkumar.recruitment_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key

    @OneToOne(mappedBy = "profile") // mapped by 'profile' in User
    @ToString.Exclude // avoid circular reference
    @JsonBackReference
    private User applicant;

    private String resumeFileAddress;
    private String skills;
    private String education;
    private String experience;

    public Profile(User applicant, String resumeFileAddress, String skills, String education, String experience) {
        this.applicant = applicant;
        this.resumeFileAddress = resumeFileAddress;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
    }
}
