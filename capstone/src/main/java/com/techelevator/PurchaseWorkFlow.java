package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PurchaseWorkFlow  {


    protected double moneyFed;
    protected double currentMoney;
    protected double totalCost;

    public PurchaseWorkFlow() {
        currentMoney = 0.0;
    }


    public void getMoneyFromUser(double moneyFed, double totalCost){
        Scanner insertedMoney = new Scanner(System.in);
        double userMoney = Integer.parseInt(insertedMoney.nextLine());
        double currentMoney = 0;

        while (moneyFed != totalCost){
            currentMoney += userMoney;
            System.out.println(currentMoney);


        }

    }

    public void feedMoney(double moneyFed) {
        this.currentMoney += moneyFed;
    }

    public void purchase(double price) {
        this.currentMoney -= price;

    }

    public double getCurrentMoney() {
        return currentMoney;
    }

}
