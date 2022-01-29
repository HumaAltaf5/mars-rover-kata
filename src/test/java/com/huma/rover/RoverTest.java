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
        String expected = "10 10";

        // Act and Assert
        plateau.setPlateauSize(10,10);
        assertEquals(expected, plateau.getPlateauSize());
    }

    @Test
    public void TestToGetXAndYCoordinate() {
        //Assert
        String input1 = "1 2 N";
        String expected = "1 2";

        //Act and Assert
        Coordinate coordinate =  new Coordinate(Character.getNumericValue(input1.charAt(0)), Character.getNumericValue(input1.charAt(2)));
        assertEquals(coordinate.getX() + " " + coordinate.getY(), expected);
    }

    @Test
    public void TestToRotateLeft() {
        //Arrange
        String input1 = "1 2 S";
        String expected = "E";
        Direction direction = North;
        Controller controller = new Controller();
        String currentDirection = Character.toString(input1.charAt(4));
        //Act
        direction.setDirection(currentDirection);
        //Assert
        assertEquals(controller.moveRover("L"),expected);
    }

    @Test
        public void TestToRotateRight() {
        //Arrange
        String input1 = "1 2 W";
        String expected = "N";
        Direction direction = North;
        Controller controller = new Controller();
        String currentDirection = Character.toString(input1.charAt(4));
        //Act
        direction.setDirection(currentDirection);
        //Assert
        assertEquals(controller.moveRover("R"),expected);
    }
}
