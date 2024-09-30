/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tid;
    private String tname;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "type")
    private List<Users> users = new ArrayList<>();

    
    
    
    
    
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    
    
    public Type() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
    
    
    
    
}
