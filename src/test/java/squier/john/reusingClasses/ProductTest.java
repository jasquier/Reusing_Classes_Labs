package squier.john.reusingClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import squier.john.reusingClasses.inventory.Product;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ProductTest {

    Product product;

    @Before
    public void setup() {
        product = new Product(100.0, "1234", 500);
    }

    @Test
    public void getPriceTest() {
        Double expected = 100.0;
        Double actual = product.getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPriceTest() {
        Double expected = 500.0;
        product.setPrice(500.0);
        Double actual = product.getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getProductIDTest() {
        String expected = "1234";
        String actual = product.getProductID();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setProductIDTest() {
        String expected = "4321";
        product.setProductID("4321");
        String actual = product.getProductID();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantityOnHandTest() {
        Integer expected = 500;
        Integer actual = product.getQuantityOnHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setQuantityOnHandTest() {
        Integer expected = 1;
        product.setQuantityOnHand(1);
        Integer actual = product.getQuantityOnHand();
        Assert.assertEquals(expected, actual);
    }




}
