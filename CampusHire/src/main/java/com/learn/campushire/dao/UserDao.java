/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.dao;

import com.learn.campushire.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class UserDao {
     private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
   public int getTypeByEmail(String email) {
        Integer typeId = null;  
        Session session = null;
        try {
            session = factory.openSession();  
            
            String query = "SELECT u.type.id FROM Users u WHERE u.email = :email";  
            Query<Integer> q = session.createQuery(query, Integer.class);
            q.setParameter("email", email);
            
            typeId = q.getSingleResult();  
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return (typeId != null) ? typeId : 0;  
    }
   
    public Users getUserByEmailAndPassword(String email,String password)
    {
         Users user=null;
        try{
            
            String query="from Users where email =:e and psw =:p";
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e",email);
            q.setParameter("p",password);
            user=(Users)q.getSingleResult();
            
            session.close();
        
    }
        catch(Exception e)
        {
             e.printStackTrace();
        }
     
    return user;
}
    
    
    
    public void sProfile(int uid,String pic)
   {
         Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            // Load the user by ID
            Users user = session.get(Users.class, uid);
            if (user != null) {
                // Update the profile picture
                user.setProfile(pic);
                session.update(user);
                tx.commit();
            } else {
                System.out.println("User not found with ID: " + uid);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();}}
       
       
   }
   
    
}
    
    
