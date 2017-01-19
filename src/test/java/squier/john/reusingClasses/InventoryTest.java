package squier.john.reusingClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.ProtectionDomain;
import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class InventoryTest {

    Inventory inventory;
    Product product1, product2;
    ArrayList<Product> productsList;

    @Before
    public void setup() {
        product1 = new Product(1.00, "1", 1);
        product2 = new Product(2.00, "2", 2);

        productsList = new ArrayList<Product>();
        productsList.add(product1);
        productsList.add(product2);

        inventory = new Inventory(productsList);
    }

    @Test
    public void getProductsListTest() {
        productsList.add(product1);
        productsList.add(product2);

        ArrayList<Product> expected = productsList;
        ArrayList<Product> actual = inventory.getProductsList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addProductToInventoryTest() {
        inventory.addProductToInventory(product1);
        inventory.addProductToInventory(product2);

        ArrayList<Product> expected = productsList;
        ArrayList<Product> actual = inventory.getProductsList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateInventoryValueEmptyTest() {
        Inventory inventory2 = new Inventory();
        Double expected = 0.00;
        Double actual = inventory2.calculateInventoryValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateInventoryValueNonEmptyTest() {
        Double expected = 5.00;
        Double actual = inventory.calculateInventoryValue();
        Assert.assertEquals(expected, actual);
    }
}
