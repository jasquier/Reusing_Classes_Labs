package squier.john.reusingClasses.inventory;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class Inventory {

    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<Product>();
    }

    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProductsList() {
        return products;
    }

    public void addProductToInventory(Product product) {
        products.add(product);
    }

    public Double calculateInventoryValue() {
        Double totalInventoryValue = 0.0;

        for ( Product p : products) {
            totalInventoryValue += (p.getPrice() * p.getQuantityOnHand());
        }

        return totalInventoryValue;
    }
}
