package com.aditya.hibernate_chatting;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHATROOM")
public class Chatroom {

    @Id
    @GeneratedValue
    @Column(name = "chatroom_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "chatroom", cascade = { CascadeType.ALL })
    private Set<User> userList;

    @OneToMany(mappedBy = "chatroom", cascade = { CascadeType.ALL })
    private Set<Message> messageList;

    public Chatroom() {

    }

    public Chatroom(String name) {
        this.name = name;
    }

    public Chatroom(String name, Set<User> userList, Set<Message> messageList) {
        super();
        this.name = name;
        this.userList = userList;
        this.messageList = messageList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public Set<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(Set<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "Chatroom [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (((Chatroom) o).getName().equals(this.getName())) {
            return true;
        }
        return false;
    }

}
