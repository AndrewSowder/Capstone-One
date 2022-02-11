package com.techelevator;

public class Drink extends Item {

    private String sound = "Glug Glug, Yum!";

    public String getSound() {
        return sound;
    }

    public Drink(String[] array) {
        super(array);
    }
}
