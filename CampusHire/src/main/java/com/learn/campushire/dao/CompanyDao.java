/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.dao;

import com.learn.campushire.entities.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class CompanyDao {
    
    
    
    
    
     private SessionFactory factory;

    public CompanyDao(SessionFactory factory) {
        this.factory = factory;
    }
    
   //give company id from recruiters
    public int getIdFromRecruiter(int rname)
    {
        int id=0;
        return id;
    }
    
    
}
