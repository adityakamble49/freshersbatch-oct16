package com.aditya.spring_rest_hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADVERTISE")
public class Advertise {

    @Id
    @GeneratedValue
    @Column(name = "advertise_id")
    private Integer id;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "advertise", cascade = {
            CascadeType.ALL }, fetch = FetchType.EAGER)
    private Set<Message> messageSet;

    public Advertise() {
    }

    public Advertise(Integer id, User user, String title, String category,
            String description, Set<Message> messageSet) {
        super();
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.description = description;
        this.messageSet = messageSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @Override
    public String toString() {
        return "Advertise [id=" + id + ", user=" + user + ", title=" + title
                + ", category=" + category + ", description=" + description
                + ", messageSet=" + messageSet + "]";
    }

}
