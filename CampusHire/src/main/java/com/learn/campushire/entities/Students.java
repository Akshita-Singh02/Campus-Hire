/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "u_id")
    private Users user;
    
   
    private int roll;
    private String division;
    private String batch;
    private int urn;
    @Column(columnDefinition = "TEXT")  
    private String address;
    private String phone;
   
    private String resume;
    private String tenth;
    private String twelfth;
    private String grad;
    @ManyToOne
    @JoinColumn(name="crid")
    private Course course;
    private String gap;
    @ManyToMany
    @JoinTable(
        name = "students_job",
        joinColumns = @JoinColumn(name = "students_id"),
        inverseJoinColumns = @JoinColumn(name = "jobs_id")
    )
    private List<Job> jobs = new ArrayList<>();

    public String getName() {
        return user != null ? user.getName() : null;
    }
    
    
}