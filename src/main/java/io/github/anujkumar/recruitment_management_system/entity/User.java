package io.github.anujkumar.recruitment_management_system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key

    private String name;
    private String email;
    private String address;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType; // persist enum as string

    private String passwordHash;
    private String profileHeadline;

    @OneToOne(cascade = CascadeType.ALL) // one-to-one relationship
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @ToString.Exclude // prevent circular reference in toString()
    @JsonManagedReference
    private Profile profile;

    public User( String name, String email, String address, String phone, UserType userType,
            String passwordHash, String profileHeadline, Profile profile) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.userType = userType;
        this.passwordHash = passwordHash;
        this.profileHeadline = profileHeadline;
        this.profile = profile;
    }
}
