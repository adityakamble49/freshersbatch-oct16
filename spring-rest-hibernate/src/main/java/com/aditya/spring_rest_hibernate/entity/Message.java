package com.aditya.spring_rest_hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Integer id;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "advertise_id")
    private Advertise advertise;

    @Column(name = "message")
    private String message;

    public Message() {
    }

    public Message(Integer id, Advertise advertise, String message) {
        super();
        this.id = id;
        this.advertise = advertise;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advertise getAdvertise() {
        return advertise;
    }

    public void setAdvertise(Advertise advertise) {
        this.advertise = advertise;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", advertise=" + advertise + ", message="
                + message + "]";
    }

}
