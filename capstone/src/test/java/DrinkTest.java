import com.techelevator.Candy;
import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {

    String[] testArray = new String[]{ "C4","Heavy", "2.00", "Drink"};

    Drink drink = new Drink(testArray);


    @Test
    public void return_correct_sound(){

        String expected = "Glug Glug, Yum!" ;

        Assert.assertEquals("Drink item does not return correct sound",expected,drink.getSound());
    }
}
