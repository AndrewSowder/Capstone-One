import com.techelevator.Logger;
import com.techelevator.PurchaseWorkFlow;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LoggerTests {

    private File log = new File("Log.txt");

    PurchaseWorkFlow purchaseWorkFlow = new PurchaseWorkFlow();

    Scanner scanner = new Scanner(log);

    Logger testLogger = new Logger();

    @Before
    public void setUp() {
        try {
            new PrintWriter(log).close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }


    }

    public LoggerTests() throws FileNotFoundException {
    }


    @Test
    public void print_to_log_feed_money() throws IOException {
        purchaseWorkFlow.setCurrentMoney(10.00);
        double logMoneyfed = purchaseWorkFlow.getCurrentMoney() - 5.00;

        testLogger.printToLogFeedMoney(purchaseWorkFlow.getCurrentMoney(), logMoneyfed);


        String expected = scanner.nextLine();

        String destContent = Files.readString(log.toPath());

        assertEquals(expected.trim(), destContent.trim());

    }

    @Test
    public void print_to_log_item() throws IOException {
        purchaseWorkFlow.setCurrentMoney(10.00);
        double logMoneyfed = purchaseWorkFlow.getCurrentMoney() - 5.00;
        String location = "Magic Kingdom";
        String name = "chips";

        testLogger.printToLogItem(name, location, purchaseWorkFlow.getCurrentMoney(), logMoneyfed);


        String expected = scanner.nextLine();

        String destContent = Files.readString(log.toPath());

        assertEquals(expected.trim(), destContent.trim());
    }
    @Test
    public void print_to_log_give_change() throws IOException {
        purchaseWorkFlow.setCurrentMoney(10.00);
        double logMoneyfed = purchaseWorkFlow.getCurrentMoney() - 5.00;

        testLogger.printToLogChange(purchaseWorkFlow.getCurrentMoney(), logMoneyfed);


        String expected = scanner.nextLine();

        String destContent = Files.readString(log.toPath());

        assertEquals(expected.trim(), destContent.trim());

    }
}
