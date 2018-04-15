package com.example.rafaj.fragmentapp;


import java.io.Serializable;

public class Planet implements Serializable {
    private String name;
    private String size;
    private String gravity;
    private String mass;
    private int image;

    public Planet(String name, String size, String gravity, String mass, int image) {
        this.name = name;
        this.size = size;
        this.gravity = gravity;
        this.mass = mass;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getGravity() {
        return gravity;
    }

    public String getMass() {
        return mass;
    }

    public int getImage() {
        return image;
    }
}