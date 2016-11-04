package com.aditya.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENQUIRY")
public class Enquiry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "details")
    private String details;

    public Enquiry() {
    }

    public Enquiry(String details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Enquiry [id=" + id + ", details=" + details + "]";
    }

}
