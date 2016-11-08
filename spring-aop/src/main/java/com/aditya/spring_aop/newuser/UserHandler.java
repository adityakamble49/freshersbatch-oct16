package com.aditya.spring_aop.newuser;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    List<User> userList;
    public static String currentUser = null;

    public UserHandler() {
        userList = new ArrayList<User>();
    }

    public void register(String username, String password, String fullName,
            String country) {
        userList.add(new User(username, password, fullName, country));
        System.out.println("handler called");
    }

    public void login(String username, String password) {
        if (userList.stream().anyMatch(u -> u.getUsername().equals(username)
                && u.getPassword().equals(password))) {
            System.out.println("Login Successful");
            currentUser = username;
        }
    }

    public void logout() throws Exception {
        if (currentUser == null) {
            throw new Exception();
        } else {
            currentUser = null;
            System.out.println("Logout Successful");
        }
    }

}
