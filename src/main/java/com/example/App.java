package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

/**
 * 
 *    
 *              
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Configuration confg=new
        // Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        Configuration confg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(confg.getProperties()).build();
        SessionFactory sessionFactory = confg.buildSessionFactory(reg);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        
        session.getTransaction().commit();
        session.close();
        return;

    }
}
