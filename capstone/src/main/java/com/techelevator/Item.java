package com.techelevator;

public class Item implements SoundInterface{

    private String name;
    private double price;
    private String location;
    private String type;
    private String sound;
    private int quantity;

    public Item(String[] array) {
        location = array[0];
        name = array[1];
        price = Double.parseDouble(array[2]);
        type = array[3];
        quantity = 5;
        sound = getSound();
    }



    public int getQuantity() {
        return quantity;
    }
    public void setQuantiy(int quantity) {
        this.quantity = quantity;
    }

    public void dispenseItem() {
        if (quantity >= 1) {
            quantity -= 1;
        }
    }
    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSound() {
        return sound;
    }
}
