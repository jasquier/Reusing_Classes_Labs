package squier.john.reusingClasses.rotatableList;

import java.util.*;

/**
 * Created by johnsquier on 1/18/17.
 *  Learn about generics so I can avoid downcasting when extracting from the RotatableList
 */
public class RotatableList extends ArrayList {

    public RotatableList rotateList(int shift) {
        RotatableList newList = new RotatableList();

        for ( int i = 0; i < this.size(); i++ ) {
            newList.add(this.get((i + shift) % this.size()));
        }

        return newList;
    }

    public void createAndInitializeList() {
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);
        this.add(5);
        this.add(6);
    }

    private void printOutList() {
        System.out.print("[");

        // pretty print
        for ( int i = 0; i < this.size(); i++ ) {
            // handle case where i is the last element
            if ( i == this.size() - 1 ) {
                System.out.printf("%d", this.get(i));
            }
            else {
                System.out.printf("%d, ", this.get(i));
            }
        }

        System.out.print("]\n");

    }

    public void runRotateDemo() {
        RotatableList list = new RotatableList();
        list.createAndInitializeList();

        System.out.printf("Original List: ");
        list.printOutList();
        System.out.printf("Shift = %d\n", 3);

        list = list.rotateList(3);

        System.out.printf("Rotated List:  ");
        list.printOutList();
    }
}
