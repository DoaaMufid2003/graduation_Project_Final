package com.example.graduationproject.model;

public class Category {
    String name;
    String image;

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
