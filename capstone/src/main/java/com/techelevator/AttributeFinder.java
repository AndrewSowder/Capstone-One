package com.techelevator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AttributeFinder implements ItemFinder {
    private String name;
    private double price;
    private String location;
    private String type;
    private String sound;
    private static Map<String, String> itemLocationMap = new TreeMap<>();
    private static Map<String, Double> itemPrices = new HashMap<>();
    private static Map<String, String> itemSounds = new HashMap<>();

    public AttributeFinder(String location, List<String[]> list) {
        String[] strings = ItemFinder.findItem(location, list);
        this.location = location;
        name = strings[1];
        price = Double.parseDouble(strings[2]);
        type = strings[3];
        sound = getSound(type);
    }

    public AttributeFinder() {
    }

    public AttributeFinder(String[] strings) {
        location = strings[0];
        name = strings[1];
        price = Double.parseDouble(strings[2]);
        type = strings[3];
        sound = getSound(type);
        itemLocationMap.put(location, name);
        itemPrices.put(name, price);
        itemSounds.put(name, sound);

    }

    public static Map<String, String> getItemLocationMap() {
        return itemLocationMap;
    }

    public static Map<String, Double> getItemPrices() {
        return itemPrices;
    }

    public static Map<String, String> getItemSounds() {
        return itemSounds;
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
