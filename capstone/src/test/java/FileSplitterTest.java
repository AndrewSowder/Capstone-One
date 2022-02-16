import com.techelevator.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileSplitterTest {

    FileSplitter fileSplitter = new FileSplitter();
    List<Item> itemList = fileSplitter.getItemList();

    @Test
    public void test_split_line() {
        String testLine = "mickey mouse|disney";
        String[] testArray = fileSplitter.splitLine(testLine);
        String[] expectedArray = new String[]{"mickey mouse","disney"};
        Assert.assertArrayEquals("Split Line does not return correct result",expectedArray,testArray);
    }

    @Test
    public void chip_input_creates_chip_item() {
        // item 1 on list is a chip
        String[] chipTest = new String[]{"A1","Potato Crisps","3.05","Chip"};
        Chip chip = new Chip(chipTest);
        fileSplitter.splitFile();
        Assert.assertEquals("Chip input does not create chip item",chip.getClass(),itemList.get(0).getClass());

    }

    @Test
    public void candy_input_creates_candy_item() {
        // item 5 on list is a candy
        String[] candyTest = new String[]{"B1","Moonpie","1.80","Candy"};
        Candy candy = new Candy(candyTest);
        fileSplitter.splitFile();
        Assert.assertEquals("Candy input does not create candy item",candy.getClass(),itemList.get(4).getClass());
    }

    @Test
    public void drink_input_creates_drink_item() {
        // item 9 on list is drink item
        String[] drinkTest = new String[]{"C1","Cola","1.25","Drink"};
        Drink drink = new Drink(drinkTest);
        fileSplitter.splitFile();
        Assert.assertEquals("Drink input does not create drink item",drink.getClass(),itemList.get(8).getClass());
    }

    @Test
    public void gum_input_creates_gum_item() {
        // item 13
        String[] gumTest = new String[]{"D1","U-Chews","0.85","Gum"};
        Gum gum = new Gum(gumTest);
        fileSplitter.splitFile();
        Assert.assertEquals("Gum input does not create gum item",gum.getClass(),itemList.get(12).getClass());
    }

}
