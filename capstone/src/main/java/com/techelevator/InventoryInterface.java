package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public interface InventoryInterface {

    Map<String, Integer> itemNameAndQuantity = new HashMap<>();
    int MAX_QUANTITY = 5;
    int quantity = 0;

    static void stock(String name) {
        itemNameAndQuantity.put(name, MAX_QUANTITY);
    }

    static void dispenseItem(String name, int quantity) {
        int currentQuantity = itemNameAndQuantity.get(name);
        itemNameAndQuantity.put(name, currentQuantity-quantity);
    }

    static int getQuantity(String name) {
        return itemNameAndQuantity.get(name);
    }

    default Map<String, Integer> getMap() {
        return itemNameAndQuantity;
    }
}
