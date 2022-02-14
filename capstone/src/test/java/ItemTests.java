import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTests {

    String[] testArray = new String[]{ "A2","Light", "2.00", "Drink"};

    Item itemTest = new Item(testArray);



    @Test
    public void dispense_item_test(){

        itemTest.setQuantiy(5);

        itemTest.dispenseItem();

        int quantity = itemTest.getQuantity();

        Assert.assertEquals(4,quantity);

    }

    @Test
    public void test_item_out_of_stock(){

        itemTest.setQuantiy(0);

        itemTest.dispenseItem();

        int quantity = itemTest.getQuantity();

        Assert.assertEquals(0,quantity);
    }


}
