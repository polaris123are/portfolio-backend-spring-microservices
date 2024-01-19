package com.protfolio.portfolio_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userid;
    String fullname;
    private String imagePath;
    private String aboutMe;
    private String email;
    private String linkedIn;
    private String twitter;
    private String phoneNumber;
    private String specialization;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Project> projects;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Education> education;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Experience> workExperience;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Technology> technologies;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Certificate> certificates;
}
