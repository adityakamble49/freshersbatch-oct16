package com.aditya.spring.chat;

import java.util.Set;

public class Chatroom {
    private Integer id;
    private String name;
    private Set<User> userList;
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
