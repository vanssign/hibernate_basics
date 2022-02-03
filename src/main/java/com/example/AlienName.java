package com.example;

import javax.persistence.Embeddable;

//embeddable means its kinda composite, each property in AlienName will become separate column in Alien (in which hits embedded)
@Embeddable
public class AlienName {
    private String firstName;
    private String middleName;
    private String lastName;
    AlienName(){}
    public AlienName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    @Override
    public String toString() {
        return firstName+" "+middleName+" "+lastName;
    }
}
