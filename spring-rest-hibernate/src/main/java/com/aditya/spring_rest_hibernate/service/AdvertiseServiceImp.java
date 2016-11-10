package com.aditya.spring_rest_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.aditya.spring_rest_hibernate.dao.AdvertiseDao;
import com.aditya.spring_rest_hibernate.entity.Advertise;
import com.aditya.spring_rest_hibernate.entity.User;

public class AdvertiseServiceImp implements AdvertiseService {

    @Autowired
    public AdvertiseDao advertiseDao;

    public Advertise postAdvertisement(Advertise advertisement,
            String authToken) {
        return advertiseDao.addAdvertisement(advertisement);
    }

    public User registerUser(User user) {
        return advertiseDao.addUser(user);
    }

    public boolean loginUser(User user) {
        User foundUser = advertiseDao.checkUser(user);
        if (foundUser != null) {
            advertiseDao.generateToken(foundUser);
        }
        return false;
    }

}
