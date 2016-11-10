package com.aditya.spring_rest_hibernate.dao;

import com.aditya.spring_rest_hibernate.entity.Advertise;
import com.aditya.spring_rest_hibernate.entity.User;

public interface AdvertiseDao {

    public Advertise addAdvertisement(Advertise advertisement);

    public User addUser(User user);

    public User checkUser(User user);

    public boolean generateToken(User userId);

}
