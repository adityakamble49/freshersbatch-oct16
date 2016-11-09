package com.aditya.spring_rest.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aditya.spring_rest.entity.Advertisement;
import com.aditya.spring_rest.entity.User;

public class CollectionPersistance implements Persistance {

    private static CollectionPersistance instance;
    private static Integer userCount = 1;
    private static Integer advertisementCount = 1;

    private List<User> users;
    private Map<Integer, String> tokens;

    private CollectionPersistance() {
    }

    public static CollectionPersistance getInstance() {
        if (instance == null) {
            instance = new CollectionPersistance();
            instance.users = new ArrayList<User>();
            instance.tokens = new HashMap<Integer, String>();
        }
        return instance;
    }

    @Override
    public boolean registerUser(User user) {
        user.setId(userCount++);
        if (users.add(user)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean loginUser(String userName, String password) {
        Optional<User> foundUser = users.stream().findAny()
                .filter(u -> u.getUserName().equals(userName)
                        && u.getPassword().equals(password));
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            tokens.put(user.getId(), user.getFirstName() + user.getLastName());
            return true;
        }
        return false;
    }

    @Override
    public boolean logoutUser(String authToken) {
        return tokens.entrySet().removeIf(t -> t.getValue().equals(authToken));
    }

    @Override
    public User getUser(Integer userId, String authToken) {
        if (tokens.get(userId).equals(authToken)) {
            Optional<User> foundUser = users.stream().findAny()
                    .filter(u -> u.getId() == userId);
            if (foundUser.isPresent()) {
                return foundUser.get();
            }
        }
        return null;
    }

    public User getUser(String authToken) {
        Optional<Integer> foundUserId = tokens.entrySet().stream().findAny()
                .filter(u -> u.getValue().equals(authToken))
                .map(e -> e.getKey());
        if (foundUserId.isPresent()) {
            Integer userId = foundUserId.get();
            User foundUser = getUser(userId, authToken);
            return foundUser;
        }

        return null;

    }

    @Override
    public boolean postAdvertisement(Advertisement advertisement,
            String authToken) {
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        advertisement.setId(advertisementCount++);
        return user.getAdvertiesments().add(advertisement);

    }

    @Override
    public boolean updateAdvertisement(Advertisement advertisement,
            String authToken) {
        Integer newId = advertisement.getId();
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        for (Advertisement oldAd : user.getAdvertiesments()) {
            if (oldAd.getId() == newId) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Advertisement> readAdvertisements(String authToken) {
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        return user.getAdvertiesments();
    }

    @Override
    public List<Advertisement> searchAdvertisements(String text,
            String authToken) {
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        List<Advertisement> ads = user.getAdvertiesments();
        return ads.stream().filter(t -> {
            if (t.getTitle().contains(text) || t.getDescription().contains(text)
                    || t.getCategory().contains(text)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public Advertisement readAdvertisement(Integer id, String authToken) {
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        Optional<Advertisement> foundAd = user.getAdvertiesments().stream()
                .findAny().filter(ad -> ad.getId() == id);
        if (foundAd.isPresent()) {
            return foundAd.get();
        }
        return null;
    }

    @Override
    public List<String> readCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Hardware");
        categories.add("Software");
        return categories;
    }

    @Override
    public boolean deleteAdvertisement(Integer id, String authToken) {
        User user = getUser(authToken);
        if (user.getAdvertiesments() == null) {
            user.setAdvertiesments(new ArrayList<Advertisement>());
        }
        return user.getAdvertiesments().removeIf(ad -> ad.getId() == id);
    }

    @Override
    public boolean sendMessage(String message, String authToken) {
        return true;
    }

}
