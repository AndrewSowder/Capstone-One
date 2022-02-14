import com.techelevator.Chip;
import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Test;

public class ChipTest {
    String[] testArray = new String[]{ "A1","Crunch", "2.00", "Chip"};

     Chip chip= new Chip(testArray);


    @Test
    public void return_correct_sound(){

        String expected = "Crunch Crunch, Yum!";

        Assert.assertEquals(expected,chip.getSound());
    }
}

