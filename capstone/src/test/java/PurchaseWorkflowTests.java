import com.techelevator.PurchaseWorkFlow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseWorkflowTests {


    PurchaseWorkFlow purchaseWorkFlow = new PurchaseWorkFlow();

    @Test
    public void feed_money_test(){
        // arrange
        double curentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = 1.00;
        // act
        purchaseWorkFlow.feedMoney(moneyFed);
        //act
        Assert.assertEquals(curentMoney + moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);

    }

    @Test
    public void feed_money_with_negative_money_test(){
        double curentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = -1.00;
        // act
        purchaseWorkFlow.feedMoney(moneyFed);
        //act
        Assert.assertEquals(curentMoney + moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);
    }

    @Test
    public void feed_money_with_zero_test(){
        double curentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = 0;
        // act
        purchaseWorkFlow.feedMoney(moneyFed);
        //act
        Assert.assertEquals(curentMoney + moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);
    }

    @Test
    public void purchase_test(){
        double currentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = 2.00;

        purchaseWorkFlow.purchase(moneyFed);

        Assert.assertEquals(currentMoney - moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);
    }

    @Test
    public void purchase_with_negative_test(){
        double currentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = -2.00;

        purchaseWorkFlow.purchase(moneyFed);

        Assert.assertEquals(currentMoney - moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);
    }

    @Test
    public void purchase_with_zero_value_test(){
        double currentMoney = purchaseWorkFlow.getCurrentMoney();
        double moneyFed = 0.00;

        purchaseWorkFlow.purchase(moneyFed);

        Assert.assertEquals(currentMoney - moneyFed, purchaseWorkFlow.getCurrentMoney(),0.01);
    }

    @Test
    public void quarters_to_return_test(){
        int quartersToReturn = purchaseWorkFlow.quartersToReturn(100);

        Assert.assertEquals(4, quartersToReturn);

    }

    @Test
    public void quarters_to_return_with_less_than_value_of_quarter_test(){
        int quartersToReturn = purchaseWorkFlow.quartersToReturn(24);

        Assert.assertEquals(0, quartersToReturn);

    }

    @Test
    public void dimes_to_return_test(){
        purchaseWorkFlow.setNumberOfCents(20);

        Assert.assertEquals(2,purchaseWorkFlow.dimesToReturn());
    }

    @Test
    public void dimes_to_return_value_less_than_dime_test(){
        purchaseWorkFlow.setNumberOfCents(9);

        Assert.assertEquals(0,purchaseWorkFlow.dimesToReturn());
    }

    @Test
    public void nickels_to_return_test(){
        purchaseWorkFlow.setNumberOfCents(10);

        Assert.assertEquals(2,purchaseWorkFlow.nickelsToReturn());
    }

    @Test
    public void nickels_to_return_with_value_less_than_nickel_test(){
        purchaseWorkFlow.setNumberOfCents(4);

        Assert.assertEquals(0,purchaseWorkFlow.nickelsToReturn());
    }






}
