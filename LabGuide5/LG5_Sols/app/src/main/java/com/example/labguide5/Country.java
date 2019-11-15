package com.example.labguide5;

public class Country {
    int logo;
    String name;
    String words;

    public Country(int logo, String name, String words) {
        this.logo = logo;
        this.name = name;
        this.words = words;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Country{" +
                "logo=" + logo +
                ", name=" + name +
                ", wrods=" + words +
                '}';
    }
}