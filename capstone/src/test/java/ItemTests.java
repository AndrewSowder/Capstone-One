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

        Assert.assertEquals("Dispense item does not create correct quantity",4,quantity);

    }

    @Test
    public void test_item_out_of_stock(){

        itemTest.setQuantiy(0);

        itemTest.dispenseItem();

        int quantity = itemTest.getQuantity();

        Assert.assertEquals("Item should not be dispensed when out of stock",0,quantity);
    }

    @Test
    public void assign_correct_location(){
        Assert.assertEquals("Item location is not correctly assigned","A2",itemTest.getLocation());
    }
    @Test
    public void assign_correct_price(){
        Assert.assertEquals("Item price is not correctly assigned",2.00,itemTest.getPrice(),0.01);
    }
    @Test
    public void assign_correct_type(){
        Assert.assertEquals("Item type is not correctly assigned","Drink",itemTest.getType());
    }
    @Test
    public void assign_correct_name() {
        Assert.assertEquals("Item name is not correctly assigned","Light",itemTest.getName());
    }


}
