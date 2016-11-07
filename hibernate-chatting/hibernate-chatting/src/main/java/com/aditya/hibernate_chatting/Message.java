package com.aditya.hibernate_chatting;

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

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom;

    public Message() {
    }

    public Message(String message, Chatroom chatroom) {
        super();
        this.message = message;
        this.chatroom = chatroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", message=" + message + "]";
    }
}
