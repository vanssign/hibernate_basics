package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Student student;

    Laptop() {
    };

    Laptop(Long id, String name, Student student) {
        this.name = name;
        this.id = id;
        this.student = student;
    }

    Laptop(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
