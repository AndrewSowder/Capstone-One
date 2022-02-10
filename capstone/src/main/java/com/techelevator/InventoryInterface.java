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

    default Map<String, Integer> getMap() {
        return itemNameAndQuantity;
    }
}
