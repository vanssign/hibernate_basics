package com.example;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
public class Student {
    private String name;
    @Id
    private Long id;
    private Integer marks;
    // @OneToOne
    // private Laptop laptop;

    //if mapped by not mentioned then a new mapping table is also created
    //mappedBy which variable of laptop
    //its basically like delegating stuff
    //gotta add to Laptop Class the student reference in the student variable, otherwise its gonna be null

    //fetch type by defualt is Lazy no joins, eager makes joins
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    Student() {
    }

    Student(Long id, String name, Integer marks,List<Laptop> laptops) {
        this.id = id;
        this.marks = marks;
        this.name = name;
        this.laptops=laptops;
    }

    Student(String name, Integer marks,List<Laptop> laptops) {
        this.marks = marks;
        this.name = name;
        this.laptops=laptops;
    }
    public List<Laptop> getLaptops() {
        return laptops;
    }
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    public Long getId() {
        return id;
    }

    public Integer getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }
}
