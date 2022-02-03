package com.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;


public class HQL {
   public void basic(Session session){

        //HQL
        //in HQL, instead of table names, className will be used and similarly for columns, properties
        //Query on type Alien
        Query<Alien> hql1=session.createQuery("from Alien");
        //returns list of Alien
        List<Alien> selectedAlienList=hql1.list();
        // for(Alien alien : selectedAlienList ){
        //     System.out.println(alien);
        // }

   }
   public void propertyFetch(Session session){
    Query<Alien> hql2=session.createQuery("from Alien where firstName='vansh'");
    Alien selectedAlien=hql2.uniqueResult();
    // System.out.println(selectedAlien);

    //specifying properties, fetching selected columns
    //illegal to use like name='vansh singh thind' since name cannot be string
    // Query<Object> hql3=session.createQuery("select name from Alien");
    // List<Object> selectedObj=hql3.list();
    // for(Object oneObj:selectedObj){
    //     System.out.println(oneObj);
    // }
    Query<AlienName> hql4=session.createQuery("select name from Alien");
    List<AlienName> selectedNames=hql4.list();
    for(AlienName oneObj:selectedNames){
        System.out.println(oneObj);
    }
   }

   public void ParamterSetting(Session session){
       Query<AlienName> hql1=session.createQuery("select name from Alien where name=:selectedName");
       AlienName selectedName=new AlienName("vansh","singh","thind");
       hql1.setParameter("selectedName", selectedName);
       AlienName res=hql1.uniqueResult();
       System.out.println(res);
   }

   public void sqlQuery(Session session){
       //native queries give objects, gotta add entity (kinda cast it)
       Query<Alien> sql1=session.createNativeQuery("select * from newalien;").addEntity(Alien.class);
       List<Alien> allAliens=sql1.list();
       for(Alien alien:allAliens){
           System.out.println(allAliens.toString());
       }
   }


   public void sqlObjQuery(Session session){
    Query<Object> sql1=session.createNativeQuery("select * from newalien;");
    //mappinf from Object to Map 
    sql1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    List<Object> allAliens=sql1.list();
    for(Object alien:allAliens){
       Map mappedAlien=(Map)alien;
       System.out.println(mappedAlien.get("firstName")+": "+mappedAlien.get("id"));
    }
   }
}
