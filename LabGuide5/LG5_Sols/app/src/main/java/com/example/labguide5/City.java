package com.example.labguide5;

public class City {
    private String name;
    private int imgID;

    public City(String name, int imgID) {
        this.name = name;
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgID;
    }

    public void setImgId(int imgID) {
        this.imgID = imgID;
    }

    @Override
    public String toString() {
        return "City: " + "name='" + name ;

    }
}


