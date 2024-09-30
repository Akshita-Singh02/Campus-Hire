/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.campushire.dao;

import com.learn.campushire.entities.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author akshita
 */
public class TypeDao {
    
     private SessionFactory factory;

    public TypeDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //gives list of types
    
    public List<Type> getType()
    {
        Session s = this.factory.openSession();
        Query query=s.createQuery("from Type");
        List<Type> list=query.list();
        s.close();
        return list;
    }
    
    //from userid gets type name
    public String getTypeNameFromUser(int userid)
    {
        String name="";
        Session s = this.factory.openSession();
        Query<String> query=s.createQuery("SELECT tname from Type where tid =: userid",String.class);
        query.setParameter("userid",userid);
        name = query.getSingleResult();  
        return name;
    }
    
}
