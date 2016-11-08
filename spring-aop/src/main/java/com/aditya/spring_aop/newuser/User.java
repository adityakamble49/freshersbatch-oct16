package com.aditya.spring_aop.newuser;

public class User {

    private String username;
    private String password;
    private String fullName;
    private String country;

    public User() {
    }

    public User(String username, String password, String fullName,
            String country) {
        super();
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password
                + ", fullName=" + fullName + ", country=" + country + "]";
    }

}
