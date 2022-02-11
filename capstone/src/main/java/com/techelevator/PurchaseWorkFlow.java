package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PurchaseWorkFlow  {

    private double currentMoney;

    public PurchaseWorkFlow() {
        currentMoney = 0.0;
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
    public void setCurrentMoney(double moneys){
        currentMoney = moneys;
    }

}
