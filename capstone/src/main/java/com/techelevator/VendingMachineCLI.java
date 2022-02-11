package com.techelevator;

import com.techelevator.view.Menu;

import java.awt.geom.Arc2D;
import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {


        while (true) {
            PurchaseWorkFlow purchaseWorkFlow = new PurchaseWorkFlow();
            AttributeFinder attributeFinder = new AttributeFinder();
            Scanner scanner = new Scanner(System.in);
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

                // display vending machine items


                FileSplitter fileSplitter = new FileSplitter();
                Map<String, Integer> itemQuantities = fileSplitter.getMap();
                for (Map.Entry<String, Integer> item : itemQuantities.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue());
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                while (!choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                    if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        //
                        System.out.print("Enter dollar amount to insert >>> ");

                        String moneyInputStr = scanner.nextLine();
                        int moneyInput = 0;
                        boolean loopDone = false;
                        while (!loopDone) {
                            try {
                                moneyInput = Integer.parseInt(moneyInputStr);
                                loopDone = true;
                            } catch (Exception e) {
                                System.out.print("Please enter valid dollar amount >>> ");
                                moneyInputStr = scanner.nextLine();
                            }
                        }
                        purchaseWorkFlow.feedMoney(moneyInput);
                        System.out.println(" ");
                        System.out.println("Current Money Provided: " + purchaseWorkFlow.getCurrentMoney());
                    } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        Map<String, String> itemLocation = AttributeFinder.getItemLocationMap();
                        for (Map.Entry<String, String> item : itemLocation.entrySet()) {
                            System.out.println(item.getKey() + " - " + item.getValue());
                        }
                        // get location input, ensure it's validity
                        System.out.println(" ");
                        System.out.print("Enter location >>> ");
                        String userLocationInput = scanner.nextLine();
                        String itemSelected = "";
                            for (Map.Entry<String, String> item : itemLocation.entrySet()) {
                                if (userLocationInput.contains(item.getKey())) {
                                    itemSelected += item.getValue();
                                }
                            }
                            if (itemSelected.equals("")) {
                                System.out.println("Selected location not available.");
                                break;
                            }
                        System.out.println(" ");
                        Map<String, Double> itemPrices = AttributeFinder.getItemPrices();
                        Map<String, String> itemSounds = AttributeFinder.getItemSounds();
                        int itemQuantity = InventoryInterface.getQuantity(itemSelected);
                        double currentMoney = purchaseWorkFlow.getCurrentMoney();
                        if (itemQuantity > 0 ) {
                            if (currentMoney >= itemPrices.get(itemSelected)) {
                                // dispense
                                System.out.println(itemSelected + " dispensed. ");
                                System.out.println("Cost: " + itemPrices.get(itemSelected));
                                purchaseWorkFlow.purchase(itemPrices.get(itemSelected));
                                System.out.println("Money Remaining: " + purchaseWorkFlow.getCurrentMoney());
                                InventoryInterface.dispenseItem(itemSelected, 1);
                                System.out.println(itemSounds.get(itemSelected));
                            } else {
                                System.out.println("Insufficient funds.");
                            }
                        } else {
                            System.out.println("Selected item is sold out.");
                            break;
                        }


                    } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        double moneyToReturn = purchaseWorkFlow.getCurrentMoney();

                        int numberOfCents = (int) (moneyToReturn * 100);

                        int nickel = 5 ;
                        int dime = 10;
                        int quarter = 25;
                        int nickelQty = 0;
                        int dimeQty = 0;
                        int quarterQty = 0;

                        while(numberOfCents >= quarter){
                            quarterQty += 1;
                            numberOfCents -= quarter;
                        }
                        while(numberOfCents >= dime){
                            dimeQty += 1;
                            numberOfCents -= dime;
                        }
                        while (numberOfCents >= nickel){
                            nickelQty += 1;
                            numberOfCents -= nickel;
                        }
                        moneyToReturn = (double)numberOfCents  / 100;
                        purchaseWorkFlow.setCurrentMoney(moneyToReturn);
                        System.out.println("Change Returned");
                        System.out.println("Quarters Returned: " + quarterQty);
                        System.out.println("Dimes Returned: "+ dimeQty);
                        System.out.println("Nickels Returned: "+ nickelQty);




                    }
                }

            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                exit(0);
            }
        }
    }


    public static void main(String[] args) {
        FileSplitter fileSplitter = new FileSplitter();
        fileSplitter.splitFile("C:\\Users\\Student\\workspace\\capstone-1-team-6\\capstone\\vendingmachine.csv");

        PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);





        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }

}
