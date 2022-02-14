package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {

    private File log = new File("Log.txt");

    private DecimalFormat formatter = new DecimalFormat("#0.00");


    PrintWriter logPrint = new PrintWriter(new FileOutputStream(log, true));

    public Logger() throws FileNotFoundException {
    }


    public String dateTime() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return date + " " + time;

    }

    public void printToLogFeedMoney(double currentMoney, double logMoneyfed) {
        String lineToPrint = dateTime() + " FEED MONEY: " + "$" + formatter.format(currentMoney) + " $" + formatter.format(logMoneyfed);
        logPrint.println(lineToPrint);
        logPrint.flush();



    }

    public void printToLogItem(String name, String location, double moneyBefore, double moneyAfter) {
        String lineToPrint = dateTime() + " " + name + " " + location + " $" + formatter.format(moneyBefore) + " $" +  formatter.format(moneyAfter);
        logPrint.println(lineToPrint);
        logPrint.flush();

    }

    public void printToLogChange(double initalMoney, double remainingMoney){
        String lineToPrint = dateTime() + " GIVE CHANGE: " + "$" + formatter.format(initalMoney) + " $" + formatter.format(remainingMoney);
        logPrint.println(lineToPrint);
        logPrint.flush();

    }
    public void closeLogPrint(){
        logPrint.close();
    }

}
