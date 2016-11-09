package com.aditya.spring_rest.db;

import java.util.List;

import com.aditya.spring_rest.entity.Advertisement;
import com.aditya.spring_rest.entity.User;

public interface Persistance {

    public boolean registerUser(User user);

    public boolean loginUser(String username, String password);

    public boolean logoutUser(String authToken);

    public User getUser(Integer userId, String authToken);

    public boolean postAdvertisement(Advertisement advertisement,
            String authToken);

    public boolean updateAdvertisement(Advertisement advertisement,
            String authToken);

    public List<Advertisement> readAdvertisements(String authToken);

    public List<Advertisement> searchAdvertisements(String text,
            String authToken);

    public Advertisement readAdvertisement(Integer id, String authToken);

    public List<String> readCategories();

    public boolean deleteAdvertisement(Integer id, String authToken);

    public boolean sendMessage(String message, String authToken);

}
