/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recruiter")
public class Recruiter {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int rid;
   
    @OneToOne
    @JoinColumn(name = "c_id")
    private Company cid;
    
    @OneToOne
    @JoinColumn(name = "u_id")
    private Users user;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rid")
    private List<Job> jobs = new ArrayList<>();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Company getCid() {
        return cid;
    }

    public void setCid(Company cid) {
        this.cid = cid;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    
    
    
}

