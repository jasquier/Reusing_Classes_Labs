package squier.john.reusingClasses.rotatableList;

import java.util.*;

/**
 * Created by johnsquier on 1/18/17.
 *  Learn about generics so I can avoid down-casting when extracting from the RotatableList
 *  1/20/16 : Implemented generic functionality
 */
public class RotatableList<E> extends ArrayList<E> {

    public RotatableList() {
        super();
    }

    public RotatableList<E> rotateList(int shift) {
        RotatableList<E> newList = new RotatableList<>();

        for ( int i = 0; i < this.size(); i++ ) {
            newList.add(this.get((i + shift) % this.size()));
        }

        return newList;
    }

    // relies on the toString() method of the type you pass in
    //  if the toString() prints out weird object info then you need to overRIDE
    //  toString() for your class
    public void printOutList() {
        System.out.print("[");

        // pretty print
        for ( int i = 0; i < this.size(); i++ ) {
            // handle case where i is the last element
            if ( i == this.size() - 1 ) {
                System.out.printf("%s", this.get(i));
            }
            else {
                System.out.printf("%s, ", this.get(i));
            }
        }

        System.out.print("]\n");
    }
}
