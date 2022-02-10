package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final int MAX_QUANTITY = 5;
    private int quantity;
    Map<String, Integer> itemNameAndQuantity = new HashMap<>();

    // create a map of item name and quantity, refer back to when altering quantity
    public void stock(String name) {
        itemNameAndQuantity.put(name, MAX_QUANTITY);
    }

    public Map<String, Integer> getMap() {
        return itemNameAndQuantity;
    }
}
