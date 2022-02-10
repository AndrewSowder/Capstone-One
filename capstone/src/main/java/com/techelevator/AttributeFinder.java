package com.techelevator;
import java.util.List;

public class AttributeFinder implements ItemFinder {
    private String name;
    private double price;
    private String location;
    private String type;
    private String sound;

    public AttributeFinder(String location, List<String[]> list) {
        String[] strings = ItemFinder.findItem(location, list);
        this.location = location;
        name = strings[1];
        price = Double.parseDouble(strings[2]);
        type = strings[3];
        sound = getSound(type);
    }

    public AttributeFinder(String[] strings) {
        location = strings[0];
        name = strings[1];
        price = Double.parseDouble(strings[2]);
        type = strings[3];
        sound = getSound(type);

    }

    private String getSound(String type) {
        switch (type) {
            case "Chip":
                return "Crunch Crunch, Yum!";
            case "Candy":
                return "Munch Munch, Yum!";
            case "Drink":
                return "Glug Glug, Yum!";
            case "Gum":
                return "Chew Chew, Yum!";
            default:
                return "type was not correctly converted into sound";
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }
}
