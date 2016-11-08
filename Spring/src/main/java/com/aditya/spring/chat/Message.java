package com.aditya.spring.chat;

public class Message {

    private Integer id;

    private String message;

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
