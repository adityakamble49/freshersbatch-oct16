package com.aditya.spring_rest_hibernate.service;

import com.aditya.spring_rest_hibernate.entity.Advertise;
import com.aditya.spring_rest_hibernate.entity.User;

public interface AdvertiseService {
    public Advertise postAdvertisement(Advertise advertisement,
            String auth_token);

    public User registerUser(User user);

    public boolean loginUser(User user);
}
