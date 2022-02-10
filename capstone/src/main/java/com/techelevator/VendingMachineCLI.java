package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

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
    private PurchaseMenu purchaseMenu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }
    public void PurchaseMenuCLI(PurchaseMenu menu) {
        this.purchaseMenu = menu;
    }

    public void run() {


        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

                // display vending machine items


                FileSplitter fileSplitter = new FileSplitter();
                Map<String, Integer> itemQuantities = fileSplitter.getMap();
                for (Map.Entry<String, Integer> item : itemQuantities.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue());
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    //

                } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                    //

                } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                }


            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                exit(0);
            }
        }
    }


    public static void main(String[] args) {
        FileSplitter fileSplitter = new FileSplitter();
        fileSplitter.splitFile("vendingmachine.csv");

        PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);





        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }

}
