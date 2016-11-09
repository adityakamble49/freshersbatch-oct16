package com.aditya.spring_rest.entity;

import java.util.List;

public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private List<Advertisement> advertiesments;
    private List<String> messages;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String userName,
            String password, String email, String phoneNumber,
            List<Advertisement> advertiesments, List<String> messages) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phoneNumber;
        this.advertiesments = advertiesments;
        this.messages = messages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public List<Advertisement> getAdvertiesments() {
        return advertiesments;
    }

    public void setAdvertiesments(List<Advertisement> advertiesments) {
        this.advertiesments = advertiesments;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", username=" + userName + ", password=" + password
                + ", email=" + email + ", phoneNumber=" + phone
                + ", advertiesments=" + advertiesments + ", messages="
                + messages + "]";
    }

}
