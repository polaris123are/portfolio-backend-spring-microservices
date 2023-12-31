package com.protfolio.portfolio_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "portfolios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagePath;
    private String aboutMe;
    private String email;
    private String linkedIn;
    private String twitter;
    private String phoneNumber;
    private String specialization;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Education> education;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Experience> workExperience;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Technology> technologies;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Certificate> certificates;
}
