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
public class CourseDao {
    
    private SessionFactory factory;

    public CourseDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //gives list of course
    
    public List<Course> getCourse()
    {
        Session s = this.factory.openSession();
        Query query=s.createQuery("from Course");
        List<Course> list=query.list();
        s.close();
        return list;
    }
    
    
    
    
}
