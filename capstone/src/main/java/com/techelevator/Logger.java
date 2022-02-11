package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {

    private File log = new File("Log.txt");




    PrintWriter logPrint = new PrintWriter(new FileOutputStream(log, true));

    public Logger() throws FileNotFoundException {
    }


    public String dateTime() {

        LocalDate date = LocalDate.now();
        String dates = date.toString();
        return dates;


    }

    public void printToLogFeedMoney(double currentMoney, double logMoneyfed) {
        String lineToPrint = dateTime() + " FEED MONEY: " + "$" + currentMoney + " $" + logMoneyfed;
        logPrint.println(lineToPrint);
        logPrint.flush();



    }

    public void printToLogItem(String name, String location, double moneyBefore, double moneyAfter) {
        String lineToPrint = dateTime() + " " + name + " " + location + " $" + moneyBefore + " $" +  moneyAfter;
        logPrint.println(lineToPrint);
        logPrint.flush();

    }

    public void printToLogChange(double initalMoney, double remainingMoney){
        String lineToPrint = dateTime() + " GIVE CHANGE: " + "$" + initalMoney + " $" + remainingMoney;
        logPrint.println(lineToPrint);
        logPrint.flush();

    }
    public void closeLogPrint(){
        logPrint.close();
    }

}
