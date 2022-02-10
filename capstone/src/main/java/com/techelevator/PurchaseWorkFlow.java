package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseWorkFlow  {


    protected double moneyFed;
    protected double totalCost;


    public void getMoneyFromUser(double moneyFed, double totalCost){
        Scanner insertedMoney = new Scanner(System.in);
        double userMoney = Integer.parseInt(insertedMoney.nextLine());
        double currentMoney = 0;

        while (moneyFed != totalCost){
            currentMoney += userMoney;
            System.out.println(currentMoney);


        }

    }

}
