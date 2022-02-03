package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Caching {
    public void example(SessionFactory sessionFactory){
        //for a session, hibernate provides first level caching by default
        //gotta use ehcache for second level caching
        Session session=sessionFactory.openSession();
        Alien test=new Alien();
        test=(Alien)session.get(Alien.class,23);
        System.out.println(test);
        System.out.println("-----One fetch complete-----");
        Alien test2=new Alien();
        test2=(Alien) session.get(Alien.class,23);
        System.out.println(test);
        session.getTransaction().commit();

        //caching haapens when you find database responds with a not null object
        System.out.println("----new Session-----");
        Session s2=sessionFactory.openSession();
        s2.beginTransaction();
        Alien test3=new Alien();
        //aint gonna fetch from databse but use second level cache
        test3=(Alien)session.get(Alien.class,23);
        s2.getTransaction().commit();
        session.close();
        s2.close();

        Query<Alien> q1= session.createQuery("from Alien where id=23");
        q1.setHint( "org.hibernate.cacheable", "true");
        Alien test321=q1.getSingleResult();
        System.out.println("---New fetch---");
        Alien test123=q1.getSingleResult();
        session.getTransaction().commit();

        //second level cache check
        Session s3=sessionFactory.openSession();
        s2.beginTransaction();
        System.out.println("-----Second level fetching-----");
        Alien Test1234=q1.getSingleResult();
        s2.getTransaction().commit();
    }
}
