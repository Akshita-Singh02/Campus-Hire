/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class StudentDao {
     private SessionFactory factory;

    public StudentDao(SessionFactory factory) {
        this.factory = factory;
    }
     
      //get student count
    
     public int getstudentCount()
    {
        int c = 0;
        Session session = null;
    try {
        String query = "SELECT COUNT(j) FROM Job j";
        session = this.factory.openSession();
        Query<Long> q = session.createQuery(query, Long.class);
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
    
    
    @PersistenceContext
    private EntityManager entityManager;

    public long countStudentsByCompanyId(int companyId) {
        // JPQL query to count the number of distinct students for a specific company
        String hql = "SELECT COUNT(DISTINCT s) FROM company c "
                   + "JOIN c.job j "
                   + "JOIN j.students s "
                   + "WHERE c.compid = :companyId";
        Long count = entityManager.createQuery(hql, Long.class)
                                  .setParameter("companyId", companyId)
                                  .getSingleResult();
        return count;
    }
    
    
}
