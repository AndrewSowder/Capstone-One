import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

    String[] testArray = new String[]{ "B2","Wonka", "2.00", "Candy"};

    Candy candy = new Candy(testArray);


    @Test
    public void return_correct_sound(){

        String expected =  "Munch Munch, Yum!";

        Assert.assertEquals(expected,candy.getSound());
    }
}
