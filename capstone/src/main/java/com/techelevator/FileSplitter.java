package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileSplitter {

    private List<Item> itemList;

    public FileSplitter() {
        itemList = new ArrayList<>();
    }

   /* public void splitFile(String filePath){
        File file = new File(filePath);

        try (Scanner fileScan = new Scanner(file)) {
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] lineSplit = splitLine(line);
                list.add(lineSplit);
                AttributeFinder attributeFinder = new AttributeFinder(lineSplit);
                InventoryInterface.stock(attributeFinder.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File path not valid." + e);
            System.exit(0);
        }

    } */

    public void splitFile() {

            String path = "C:\\Users\\Student\\workspace\\capstone-1-team-6\\capstone\\vendingmachine.csv";
            File file = new File(path);


            try (Scanner fileScan = new Scanner(file)) {


                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    String[] lineSplit = splitLine(line);
                    Item item = new Item(lineSplit);
                    String type = item.getType();

                    // do NOT make into a switch!!!!!!
                    if (type.equals("Chip")) {
                        Chip chip = new Chip(lineSplit);
                        itemList.add(chip);
                    } else if (type.equals("Candy")) {
                        Candy candy = new Candy(lineSplit);
                        itemList.add(candy);
                    } else if (type.equals("Drink")) {
                        Drink drink = new Drink(lineSplit);
                        itemList.add(drink);
                    } else if (type.equals("Gum")) {
                        Gum gum = new Gum(lineSplit);
                        itemList.add(gum);
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }

    }

    public List<Item> getItemList() {
        return itemList;
    }

    private String[] splitLine(String line) {
        return line.split("\\|");
    }

}
