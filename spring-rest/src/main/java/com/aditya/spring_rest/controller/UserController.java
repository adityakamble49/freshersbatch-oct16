package com.aditya.spring_rest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.spring_rest.db.CollectionPersistance;
import com.aditya.spring_rest.db.Persistance;
import com.aditya.spring_rest.entity.Advertisement;
import com.aditya.spring_rest.entity.User;

@RestController
@RequestMapping("/vision")
public class UserController {

    Persistance persistance = CollectionPersistance.getInstance();

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean registerUser(@RequestBody User user) {
        return persistance.registerUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean loginUser(@RequestBody User user) {
        return persistance.loginUser(user.getUserName(), user.getPassword());
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable(value = "userId") Integer userId,
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.getUser(userId, authToken);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public boolean loginUser(
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.logoutUser(authToken);
    }

    @RequestMapping(value = "/postAd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean postAdvertisement(
            @RequestHeader(value = "auth_token") String authToken,
            @RequestBody Advertisement advertisement) {
        return persistance.postAdvertisement(advertisement, authToken);
    }

    @RequestMapping(value = "/postAd", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateAdvertiesment(
            @RequestHeader(value = "auth_token") String authToken,
            @RequestBody Advertisement advertisement) {
        return persistance.updateAdvertisement(advertisement, authToken);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advertisement> readAllAdvertisement(
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.readAdvertisements(authToken);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Advertisement readAdvertisement(
            @PathVariable(value = "postId") Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.readAdvertisement(postId, authToken);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
    public boolean deleteAdvertisement(
            @PathVariable(value = "postId") Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.deleteAdvertisement(postId, authToken);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> readCategories() {
        return persistance.readCategories();
    }

    @RequestMapping(value = "/posts/search/{text}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advertisement> deleteAdvertisement(
            @PathVariable(value = "text") String text,
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.searchAdvertisements(text, authToken);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean sendMessage(@RequestBody String message,
            @RequestBody Integer postId,
            @RequestHeader(value = "auth_token") String authToken) {
        return persistance.sendMessage(message, authToken);
    }
}
