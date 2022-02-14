package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PurchaseWorkFlow  {

    private double currentMoney;
    private int nickel = 5;
    private int dime = 10;
    private int quarter = 25;
    private int nickelQty;
    private int dimeQty;
    private int quarterQty;
    private int numberOfCents;

    public PurchaseWorkFlow() {
        currentMoney = 0.0;
    }

    public void feedMoney(double moneyFed) {
        this.currentMoney += moneyFed;
    }

    public void purchase(double price) {
        this.currentMoney -= price;

    }

    public int quartersToReturn(int numberOfCents) {
        while (numberOfCents >= quarter) {
            quarterQty += 1;
            numberOfCents -= quarter;
        }
        this.numberOfCents = numberOfCents;
        return quarterQty;
    }

    public int dimesToReturn() {
        while (numberOfCents >= dime) {
            dimeQty += 1;
            numberOfCents -= dime;
        }
        return dimeQty;
    }

    public int nickelsToReturn() {
        while (numberOfCents >= nickel) {
            nickelQty += 1;
            numberOfCents -= nickel;
        }
        return nickelQty;
    }

    public int getNumberOfCents() {
        return numberOfCents;
    }
    public void setNumberOfCents(int cents){
        numberOfCents = cents;
    }


    public double getCurrentMoney() {
        return currentMoney;
    }
    public void setCurrentMoney(double moneys){
        currentMoney = moneys;
    }

}
