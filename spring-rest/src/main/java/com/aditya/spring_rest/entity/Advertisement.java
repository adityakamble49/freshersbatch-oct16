package com.aditya.spring_rest.entity;

import java.util.List;

public class Advertisement {

    private Integer id;
    private Integer userId;
    private String title;
    private String category;
    private String description;
    private List<String> photos;

    public Advertisement() {
    }

    public Advertisement(Integer id, Integer userId, String title,
            String category, String description, List<String> photos) {
        super();
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.photos = photos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Advertisement [id=" + id + ", userId=" + userId + ", title="
                + title + ", category=" + category + ", description="
                + description + ", photos=" + photos + "]";
    }

}
