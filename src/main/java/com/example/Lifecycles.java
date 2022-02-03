package com.example;

import org.hibernate.Session;

public class Lifecycles {
    public void start(Session session){
        Alien test = new Alien(); // transient state
        test.setId(2345);
        AlienName testname = new AlienName("pqr", "xyz", "mno");
        AlienName testName2=new AlienName("changed","now","it");
        test.setName(testname);
        session.beginTransaction();
        session.save(test); // became persistent now
        System.out.println(test);
        test.setName(testName2); // name in database also changes since test is now persistent
        //but changes in primary key will show exception
        testName2.setFirstName("why"); //firstname also changed in database;
        // session.remove(test); deleting
        session.getTransaction().commit();
        //it automatically detached after commit
        //leaving persistent state 
        //NOTE: if deatched before commit it aint gonne be stored on database
        // session.detach(test); //now changes aren't gonna be persistent
        testName2.setFirstName("rtyu");
        testName2.setFirstName("vansh");
        session.close();
    }
}
