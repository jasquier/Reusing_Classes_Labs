package squier.john.reusingClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import squier.john.reusingClasses.rotatableList.RotatableList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ListRotatorTest {

    RotatableList expectedList;

    @Before
    public void setup() {
        expectedList = new RotatableList();
        expectedList.createAndInitializeList();
    }

    @Test
    public void rotateListByZeroTest() {
        Object[] expected = {1, 2, 3, 4, 5, 6};
        Object[] actual = expectedList.rotateList(0).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListByOneTest() {
        Object[] expected = {2, 3, 4, 5, 6, 1};
        Object[] actual = expectedList.rotateList(1).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListByTwoTest() {
        Object[] expected = {3, 4, 5, 6, 1, 2};
        Object[] actual = expectedList.rotateList(2).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListByThreeTest() {
        Object[] expected = {4, 5, 6, 1, 2, 3};
        Object[] actual = expectedList.rotateList(3).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListByFourTest() {
        Object[] expected = {5, 6, 1, 2, 3, 4};
        Object[] actual = expectedList.rotateList(4).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListByFiveTest() {
        Object[] expected = {6, 1, 2, 3, 4, 5};
        Object[] actual = expectedList.rotateList(5).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListBySixTest() {
        Object[] expected = {1, 2, 3, 4, 5, 6};
        Object[] actual = expectedList.rotateList(6).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateListBySevenTest() {
        Object[] expected = {2, 3, 4, 5, 6, 1};
        Object[] actual = expectedList.rotateList(7).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void createAndInitializeListTest() {
        Object[] expected = {1, 2, 3, 4, 5, 6};

        RotatableList temp = new RotatableList();
        temp.createAndInitializeList();

        Object[] actual = temp.toArray();

        Assert.assertArrayEquals(expected, actual);
    }
}
