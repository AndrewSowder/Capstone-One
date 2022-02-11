package com.techelevator;

public class Chip extends Item {

    private String sound = "Crunch Crunch, Yum!";

    public String getSound() {
        return sound;
    }

    public Chip(String[] array) {
        super(array);
    }
}
