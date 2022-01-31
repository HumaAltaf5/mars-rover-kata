package com.huma.rover;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static com.huma.rover.Direction.*;
import static org.testng.Assert.assertEquals;

public class RoverTest {
    @Test

    public void TestToGetPlateauSize() {
        //Arrange
       Plateau plateau  = new Plateau();
       String expectedX = "10";
       String expectedY = "10";

        // Act and Assert
        plateau.setPlateauSize(10,10);
        assertEquals(String.valueOf(plateau.getMaxX()),expectedX);
        assertEquals(String.valueOf(plateau.getMaxY()),expectedY);
    }

    @Test
    public void TestToGetXAndYCoordinate() {
        //Assert
        String input1 = "1 2 N";
        String expected = "1 2";

        //Act and Assert
        Coordinate coordinate =  new Coordinate();
        coordinate.setX(Character.getNumericValue(input1.charAt(0)));
        coordinate.setY(Character.getNumericValue(input1.charAt(2)));
        assertEquals(coordinate.getX() + " " + coordinate.getY(), expected);
    }

    @Test
    public void TestToRotateLeft() {
        //Arrange
        String expected = "1 2 N";
        Controller controller = new Controller();

        //Act
        controller.getPosition(1, 2, "S");
        String actual = controller.executeCommands("LL");

        //Assert
        assertEquals(actual,expected);
    }

    @Test
    public void TestToRotateLeftMultipleTimes() {
        //Arrange
        String expected = "1 2 W";
        Controller controller = new Controller();

        //Act
        controller.getPosition(1, 2, "S");
        String actual = controller.executeCommands("LLL");

        //Assert
        assertEquals(actual,expected);
    }

    @Test
        public void TestToRotateRight() {
        //Arrange
        String expected = "1 2 N";
        Controller controller = new Controller();

        //Act
        controller.getPosition(1, 2, "W");

        //Assert
        assertEquals(controller.executeCommands("R"),expected);
    }

    @Test
        public void TestToMoveNorthOnce() {
        String input2 = "M";
        Controller controller = new Controller();
        controller.getPosition(3, 4, "N");
        String expected = "3 5 N";
        assertEquals(controller.executeCommands(input2),expected);
    }

    @Test
    public void TestToMoveNorthMultipleTimes() {
        String input2 = "MMMM";
        Controller controller = new Controller();
        controller.getPosition(3, 2, "N");
        String expected = "3 6 N";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);

    }

    @Test
    public void TestToMoveSouthMultipleTimes() {
        String input2 = "MMM";
        Controller controller = new Controller();
        controller.getPosition(3, 6, "S");
        String expected = "3 3 S";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);

    }

    @Test
    public void TestToMoveEastMultipleTimes() {
        String input2 = "MMM";
        Controller controller = new Controller();
        controller.getPosition(2, 5, "E");
        String expected = "5 5 E";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);
    }

    @Test
    public void TestToMoveWestMultipleTimes() {
        String input2 = "MM";
        Controller controller = new Controller();
        controller.getPosition(7, 2, "W");
        String expected = "5 2 W";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);
    }

    @Test
    public void TestToMoveLeftRightForward() {
        String input2 = "LRM";
        Controller controller = new Controller();
        controller.getPosition(2, 2, "N");
        String expected = "2 3 N";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);
    }

    @Test
    public void TestToMoveWhenSouthLimitReached() {
        String input2 = "MMMM";
        Controller controller = new Controller();
        controller.getPosition(2, 3, "S");
        String expected = "2 0 S";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);
    }

    @Test
    public void TestToMoveWhenWestLimitReached() {
        String input2 = "MMM";
        Controller controller = new Controller();
        controller.getPosition(2, 4, "W");
        String expected = "0 4 W";
        String actual = controller.executeCommands(input2);
        assertEquals(actual,expected);
    }

}
