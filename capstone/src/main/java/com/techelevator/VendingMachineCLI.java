package com.techelevator;

import com.techelevator.view.Menu;

import java.awt.geom.Arc2D;
import java.io.FileNotFoundException;
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
        FileSplitter fileSplitter = new FileSplitter();
        fileSplitter.splitFile();
        List<Item> itemList = fileSplitter.getItemList();
        try {
            while (true) {
                PurchaseWorkFlow purchaseWorkFlow = new PurchaseWorkFlow();
                Logger logger = new Logger();
                Scanner scanner = new Scanner(System.in);
                String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

                if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

                    for (Item item : itemList) {
                        System.out.println(item.getName() + " - " + item.getQuantity());
                    }

                } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                    while (!choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                        if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                            //
                            System.out.print("Enter dollar amount to insert >>> ");

                            String moneyInputStr = scanner.nextLine();
                            //
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
                            logger.printToLogFeedMoney(purchaseWorkFlow.getCurrentMoney(), moneyInput);
                            purchaseWorkFlow.feedMoney(moneyInput);


                            System.out.println(" ");
                            System.out.println("Current Money Provided: " + purchaseWorkFlow.getCurrentMoney());
                        } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

                            for (Item item : itemList) {
                                System.out.println(item.getLocation() + " - " + item.getName());
                            }
                            // get location input, ensure it's validity
                            System.out.println(" ");
                            System.out.print("Enter location >>> ");
                            String userLocationInput = scanner.nextLine();
                            String itemSelected = "";
                            for (Item item : itemList) {
                                if (userLocationInput.equalsIgnoreCase(item.getLocation())) {
                                    itemSelected += item.getName();
                                }
                            }
                            if (itemSelected.equals("")) {
                                System.out.println("Selected location not available.");
                                break;
                            }
                            System.out.println(" ");
                           int itemQuantity = 0;
                           double itemPrice = 0;
                            for (Item item : itemList) {
                                if (itemSelected.equals(item.getName())) {
                                    itemQuantity += item.getQuantity();
                                    itemPrice += item.getPrice();
                                }
                            }
                            double currentMoney = purchaseWorkFlow.getCurrentMoney();
                            if (itemQuantity > 0) {
                                if (currentMoney >= itemPrice) {
                                    // dispense
                                    System.out.println(itemSelected + " dispensed. ");
                                    System.out.println("Cost: " + itemPrice);
                                    purchaseWorkFlow.purchase(itemPrice);
                                    System.out.println("Money Remaining: " + purchaseWorkFlow.getCurrentMoney());
                                    String sound = "";
                                    for (Item item : itemList) {
                                        if (itemSelected.equals(item.getName())) {
                                            item.dispenseItem();
                                            sound += item.getSound();
                                        }
                                    }
                                    logger.printToLogItem(itemSelected, userLocationInput, currentMoney, purchaseWorkFlow.getCurrentMoney());
                                    System.out.println(sound);
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            } else {
                                System.out.println("Selected item is sold out.");
                                break;
                            }


                        } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                            double moneyToReturn = purchaseWorkFlow.getCurrentMoney();
//
                            int numberOfCents = (int) (moneyToReturn * 100);

                            int nickel = 5;
                            int dime = 10;
                            int quarter = 25;
                            int nickelQty = 0;
                            int dimeQty = 0;
                            int quarterQty = 0;

                            while (numberOfCents >= quarter) {
                                quarterQty += 1;
                                numberOfCents -= quarter;
                            }
                            while (numberOfCents >= dime) {
                                dimeQty += 1;
                                numberOfCents -= dime;
                            }
                            while (numberOfCents >= nickel) {
                                nickelQty += 1;
                                numberOfCents -= nickel;
                            }
                            logger.printToLogChange(moneyToReturn, numberOfCents);
                            moneyToReturn = (double) numberOfCents / 100;
                            purchaseWorkFlow.setCurrentMoney(moneyToReturn);
                            System.out.println("Change Returned");
                            System.out.println("Quarters Returned: " + quarterQty);
                            System.out.println("Dimes Returned: " + dimeQty);
                            System.out.println("Nickels Returned: " + nickelQty);


                        }
                    }

                } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                    exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }


    public static void main(String[] args) {


        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }

}
