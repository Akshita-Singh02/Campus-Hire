/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class JobDao {
    
      private SessionFactory factory;

    public JobDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //get job count
    
     public int getjCount(int id)
    {
        int c = 0;
        Session session = null;
    try {
        String query = "SELECT COUNT(j) FROM Job j WHERE id = :r_id";
        session = this.factory.openSession();
        Query<Long> q = session.createQuery(query, Long.class) .setParameter("r_id", id);
        Long count = q.getSingleResult();
        c = count.intValue();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return c;
}
    
}
