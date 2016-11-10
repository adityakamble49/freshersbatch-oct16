package com.aditya.spring_rest_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOKEN")
public class Token {

    @Id
    @Column(name = "auth_token")
    private String token;

    @Column(name = "user_id")
    private Integer userId;

    public Token() {
    }

    public Token(String token, Integer userId) {
        super();
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Token [token=" + token + ", userId=" + userId + "]";
    }

}
