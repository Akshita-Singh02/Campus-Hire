/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="job")
public class Job {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int jid;
     @ElementCollection
   
    @Column(name = "eligibility", columnDefinition = "TEXT") // Column definition for the collection
    private List<String> eligibility = new ArrayList<>();
     @Column(columnDefinition = "TEXT") 
     private String criteria;
     @Column(columnDefinition = "TEXT") 
     private String jd;
     private String ctc;
     private String stipend;
     
     @ManyToOne
    @JoinColumn(name="r_id")
     private Recruiter rid;
     
      @ManyToMany(mappedBy = "jobs")
    private List<Students> students = new ArrayList<>();

     @ManyToOne
    @JoinColumn(name="c_id")
     private Company compid;
 private LocalDate postedDate;
private LocalDate driveDate;
 private LocalDate endDate;
 
    @PrePersist
    protected void onCreate() {
        this.postedDate = LocalDate.now(); // Set current date
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public List<String> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<String> eligibility) {
        this.eligibility = eligibility;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getCtc() {
        return ctc;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public Recruiter getRid() {
        return rid;
    }

    public void setRid(Recruiter rid) {
        this.rid = rid;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Company getCompid() {
        return compid;
    }

    public void setCompid(Company compid) {
        this.compid = compid;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public LocalDate getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(LocalDate driveDate) {
        this.driveDate = driveDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Job(String criteria, String jd, String ctc, String stipend, Recruiter rid, Company compid, LocalDate postedDate, LocalDate driveDate, LocalDate endDate) {
        this.criteria = criteria;
        this.jd = jd;
        this.ctc = ctc;
        this.stipend = stipend;
        this.rid = rid;
        this.compid = compid;
        this.postedDate = postedDate;
        this.driveDate = driveDate;
        this.endDate = endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Job() {
    }

    public Job(int jid, String criteria, String jd, String ctc, String stipend, Recruiter rid, Company compid, LocalDate postedDate, LocalDate driveDate, LocalDate endDate) {
        this.jid = jid;
        this.criteria = criteria;
        this.jd = jd;
        this.ctc = ctc;
        this.stipend = stipend;
        this.rid = rid;
        this.compid = compid;
        this.postedDate = postedDate;
        this.driveDate = driveDate;
        this.endDate = endDate;
    }
    
    
     
}