package com.techelevator;
import java.util.List;

public interface ItemFinder {

    static String[] findItem(String location, List<String[]> list) {
        String[] outputItem = new String[0];
        for (String[] item : list) {
            for (String trait : item) {
                if (trait.equals(location)) {
                    outputItem = item;
                    break;
                }
            }
        }
        return outputItem;
    }
}
