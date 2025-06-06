package com.embarkx.firstjob.company;

import java.util.*;

import com.embarkx.firstjob.Reviews.Review;
import com.embarkx.firstjob.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    this is going to ignore recursive call
//    one comapny can have many job and mapped by company like it is mapping to the job
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

//    one company have multiple reviews
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
    public Company() {

    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company(Long id, String name, String description, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
