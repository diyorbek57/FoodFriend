package com.ayizor.foodfriend.models;

public class Restaurant {

    private String name, address;
    private double rating;
    private int image;

    public Restaurant() {
    }

    public Restaurant(String name, String address, double rating, int image) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
