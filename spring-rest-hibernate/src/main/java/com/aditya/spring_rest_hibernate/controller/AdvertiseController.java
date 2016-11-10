package com.aditya.spring_rest_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.spring_rest_hibernate.entity.Advertise;
import com.aditya.spring_rest_hibernate.entity.User;
import com.aditya.spring_rest_hibernate.service.AdvertiseService;

@RestController
@RequestMapping("/vision")
public class AdvertiseController {

    @Autowired
    public AdvertiseService advertiseService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User registerUser(@RequestBody User user) {
        return advertiseService.registerUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean loginUser(@RequestBody User user) {
        return advertiseService.loginUser(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable(value = "userId") Integer userId,
            @RequestHeader(value = "auth_token") String authToken) {
        return null;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public boolean loginUser(
            @RequestHeader(value = "auth_token") String authToken) {
        return false;
    }

    @RequestMapping(value = "/postAd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Advertise postAdvertisement(
            @RequestHeader(value = "auth_token") String authToken,
            @RequestBody Advertise advertisement) {
        return advertiseService.postAdvertisement(advertisement, authToken);
    }

    @RequestMapping(value = "/postAd", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateAdvertiesment(
            @RequestHeader(value = "auth_token") String authToken,
            @RequestBody Advertise advertisement) {
        return false;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advertise> readAllAdvertisement(
            @RequestHeader(value = "auth_token") String authToken) {
        return null;
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Advertise readAdvertisement(
            @PathVariable(value = "postId") Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return null;
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
    public boolean deleteAdvertisement(
            @PathVariable(value = "postId") Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return false;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> readCategories() {
        return null;
    }

    @RequestMapping(value = "/posts/search/{text}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advertise> deleteAdvertisement(
            @PathVariable(value = "text") String text,
            @RequestHeader(value = "auth_token") String authToken) {
        return null;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean sendMessage(@RequestBody String message,
            @RequestBody Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return false;
    }
}
