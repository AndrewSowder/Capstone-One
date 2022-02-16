import com.techelevator.Gum;
import org.junit.Assert;
import org.junit.Test;

public class GumTest {

    String[] testArray = new String[]{ "D2","Chew", "2.00", "Gum"};

    Gum gum = new Gum(testArray);

    @Test
    public void return_correct_sound(){

        String expected = "Chew Chew, Yum!";

        Assert.assertEquals("Gum item does not return correct sound",expected,gum.getSound());
    }
}
