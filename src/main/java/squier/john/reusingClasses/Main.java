package squier.john.reusingClasses;

import squier.john.reusingClasses.humans.Genders;
import squier.john.reusingClasses.humans.Human;
import squier.john.reusingClasses.humans.SuperHuman;
import squier.john.reusingClasses.inventory.Inventory;
import squier.john.reusingClasses.inventory.Product;
import squier.john.reusingClasses.rotatableList.RotatableList;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class Main {
    public static void main(String[] args) {

        // Demonstrate RotatableList
        RotatableList<Double> rotatableList = new RotatableList<>();

        // if you uncomment the subsequent line you will get a compilation error bc my
        //  RotatableList rotatableList is expecting Doubles
        //rotatableList.add("String");

        rotatableList.add(1.0);
        rotatableList.add(2.0);
        rotatableList.add(3.0);
        rotatableList.add(4.0);
        rotatableList.add(5.0);
        rotatableList.add(6.0);

        System.out.printf("Original List: ");
        rotatableList.printOutList();
        System.out.printf("Shift = %d\n", 2);

        rotatableList = rotatableList.rotateList(2);

        System.out.printf("Rotated List:  ");
        rotatableList.printOutList();

        // Print newline
        System.out.println();

        // Demonstrate Human and Superhuman functionality
        Human human = new Human();
        System.out.println("Default Human Info:");
        human.printInformation();
        System.out.println();

        Human human2 = new Human("John", 29, Genders.MALE, "Unemployed", "7 Cartier");
        System.out.println("Human Info:");
        human2.printInformation();
        System.out.println();

        SuperHuman superHuman = new SuperHuman();
        System.out.println("Default Superhuman Info:");
        superHuman.printInformation();
        System.out.println();

        SuperHuman superHuman2 =  new SuperHuman("John", 29, Genders.MALE, "Unemployed", "7 Cartier",
                true, "SuperJohn", "Incredible Typing Speed!");
        System.out.println("SuperHuman Info:");
        superHuman2.printInformation();
        System.out.println();

        // Demonstrate inventory and product functionality
        Inventory inventory = new Inventory();
        Product product1 = new Product(1.00, "1", 1);
        Product product2 = new Product(2.00, "2", 2);
        System.out.printf("\nTotal Inventory value when empty: %.2f\n",
                inventory.calculateInventoryValue());

        // Now add a few products
        inventory.addProductToInventory(product1);
        inventory.addProductToInventory(product2);
        System.out.printf("After adding a few prodcuts: %.2f\n",
                inventory.calculateInventoryValue());

        // And add one more
        inventory.addProductToInventory(new Product(3.00, "3", 3));
        System.out.printf("After adding another product: %.2f\n",
                inventory.calculateInventoryValue());
    }
}
