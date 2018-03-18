package com.model;

import java.io.Serializable;

/**
 * Created by asouqi on 3/13/18.
 */
public class Student implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private double average;
    private String university;

    public Student(int id, String firstName, String lastName, double average, String unvirsty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        this.university = unvirsty;
    }

    public Student() {}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverage() {
        return average;
    }

    public String getUniversity() {
        return university;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    private enum evolution{EXCLENT,VARYGOOD,GOOD,ACCEPTED}

    public evolution getEvolution(){
        if (average>=84){
            return evolution.EXCLENT;
        }
        else
            if (average>=74){
              return evolution.VARYGOOD;
            }
            else
                if (average>=65)
                    return evolution.GOOD;
            else return evolution.ACCEPTED;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", average=" + average +
                ", university='" + university + '\'' +
                '}';
    }
}
