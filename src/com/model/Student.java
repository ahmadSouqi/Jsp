package com.model;

import java.util.Date;

/**
 * Created by asouqi on 3/13/18.
 */
public class Student {

    private int id;
    private String first_name; 
    private String last_name; 
    private double avrg;
    private String unvirsty;

    public Student(int id, String first_name, String last_name, double avrg, String unvirsty) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avrg = avrg;
        this.unvirsty = unvirsty;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getAvrg() {
        return avrg;
    }

    public String getUnvirsty() {
        return unvirsty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avrg=" + avrg +
                ", unvirsty='" + unvirsty + '\'' +
                '}';
    }
}
