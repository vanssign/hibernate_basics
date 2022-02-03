package com.example;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//Entity name and table name are different
@Entity
@Table(name = "newalien")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alien {

    @Id
    private int id;

    @Column(name = "alien_name")
    private AlienName name;

    // using color is racist man, lets remove it from database
    @Transient
    private String color;

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public AlienName getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(AlienName name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Alien [id="+id+"][name="+name+"]";
    }
}
