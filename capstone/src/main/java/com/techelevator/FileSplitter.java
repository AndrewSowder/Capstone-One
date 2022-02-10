package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileSplitter implements InventoryInterface{

    private List<String[]> list;



    public FileSplitter() {
        this.list = new ArrayList<>();
    }

    public void splitFile(String filePath){
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

    }

    private String[] splitLine(String line) {
        return line.split("\\|");
    }

    public List<String[]> getList() {
        return list;
    }
}
