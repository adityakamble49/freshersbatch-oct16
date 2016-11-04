package com.aditya.mapping;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "roll_number")
    private Long rollNumber;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "STUDENT_COURSE", joinColumns = {
            @JoinColumn(name = "student_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "course_id") })
    private Set<Course> courses;

    public Student() {
    }

    public Student(String name, Long rollNumber, Set<Course> courses) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", rollNumber="
                + rollNumber + ", courses=" + courses + "]";
    }

}
