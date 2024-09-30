/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
public class Company {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int compid;
     private String name;
     private String location;
     @OneToOne
    @JoinColumn(name = "r_id")
    private Recruiter rid;
     
     @OneToMany(cascade = CascadeType.ALL,mappedBy = "jid")
    private List<Job> jobs = new ArrayList<>();

}