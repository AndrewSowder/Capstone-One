package com.techelevator;

public class Candy extends Item {

    private String sound = "Munch Munch, Yum!";

    public String getSound() {
        return sound;
    }

    public Candy(String[] array) {
        super(array);
    }
}
