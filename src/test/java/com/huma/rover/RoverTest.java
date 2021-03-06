package com.huma.rover;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static com.huma.rover.Direction.*;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class RoverTest {
    private Direction direction;
    private Coordinate coordinate;
    private Plateau plateau;
    private Controller controller;
    private Vehicle rover;
    private ArrayList<String> obstacles;

    @Before
    public void setUp() {
        direction = N;
        coordinate = new Coordinate();
        plateau = new Plateau(10, 10);
        controller = new Controller();
        rover = new MarsRover(direction, coordinate, plateau);
        obstacles = new ArrayList<String>();
        obstacles.add("1 8");
        obstacles.add("7 9");
        obstacles.add("6 8");
        obstacles.add("5 7");
    }

    @Test
    public void TestToGetPlateauSize() {
        //Arrange
        String expectedX = "10";
        String expectedY = "10";

        // Act and Assert
        assertEquals(String.valueOf(plateau.getMaxX()), expectedX);
        assertEquals(String.valueOf(plateau.getMaxY()), expectedY);
    }

    @Test
    public void TestExceptionHandlingforNegativePlateauSize() {
        String input = "-5,-5";
        String expectedMessage = "Plateau size cannot be negative";
        try {
            Plateau plateau = new Plateau(-5, -5);
        } catch (Exception e){
            assertEquals(e.getMessage(),(expectedMessage));
        }
    }

    @Test
    public void TestExceptionHandlingforInvalidRoverPosition() {
        String expectedMessage = "Invalid  x and y coordinates for Rover position.";
        try {
            controller.setRoverPosition(11, 20, "S", coordinate, direction, plateau);
        } catch (Exception e) {
            assertEquals(e.getMessage(),expectedMessage);
        }
    }

    @Test
    public void TestExceptionHandlingforNegativeRoverPosition() {
        String expectedMessage = "Invalid  x and y coordinates for Rover position.";
        try {
            controller.setRoverPosition(-11, -20, "S", coordinate, direction, plateau);
        } catch (Exception e) {
            assertEquals(e.getMessage(),expectedMessage);
        }
    }

    @Test
    public void TestToGetXAndYCoordinate() {
        //Arrange
        String input1 = "1 2 N";
        String expected = "1 2";
        coordinate.setX(Character.getNumericValue(input1.charAt(0)));
        coordinate.setY(Character.getNumericValue(input1.charAt(2)));

        //Act and Assert
        assertEquals(coordinate.getX() + " " + coordinate.getY(), expected);
    }

    @Test
    public void TestToRotateLeft() {
        //Arrange
        String expected = "1 2 E";
        controller.setRoverPosition(1, 2, "S", coordinate, direction, plateau);

        //Act
        String actual = controller.executeCommands("L", rover, coordinate, direction);

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    public void TestToRotateLeftMultipleTimes() {
        //Arrange
        String expected = "1 2 W";
        controller.setRoverPosition(1, 2, "S", coordinate, direction, plateau);

        //Act
        String actual = controller.executeCommands("LLL", rover, coordinate, direction);

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    public void TestToRotateRight() {
        //Arrange
        String expected = "1 2 N";
        controller.setRoverPosition(1, 2, "W", coordinate, direction, plateau);

        //Act and Assert
        assertEquals(controller.executeCommands("R", rover, coordinate, direction), expected);
    }

    @Test
    public void TestToMoveNorthOnce() {
        String input2 = "M";
        String expected = "3 5 N";
        controller.setRoverPosition(3, 4, "N", coordinate, direction, plateau);
        assertEquals(controller.executeCommands(input2, rover, coordinate, direction), expected);
    }

    @Test
    public void TestToMoveNorthMultipleTimes() {
        String input2 = "MMMM";
        String expected = "3 6 N";
        controller.setRoverPosition(3, 2, "N", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveSouthMultipleTimes() {
        String input2 = "MMM";
        String expected = "3 3 S";
        controller.setRoverPosition(3, 6, "S", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveEastMultipleTimes() {
        String input2 = "MMM";
        String expected = "5 5 E";
        controller.setRoverPosition(2, 5, "E", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveWestMultipleTimes() {
        String input2 = "MM";
        String expected = "5 2 W";
        controller.setRoverPosition(7, 2, "W", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveLeftRightForward() {
        String input2 = "LRM";
        String expected = "2 3 N";
        controller.setRoverPosition(2, 2, "N", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveWhenSouthLimitReached() {
        String input2 = "MMMM";
        String expected = "2 0 S";
        controller.setRoverPosition(2, 3, "S", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveWhenWestLimitReached() {
        String input2 = "MMM";
        String expected = "0 4 W";
        controller.setRoverPosition(2, 4, "W", coordinate, direction, plateau);
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveWhenNorthLimitReached() {
        String input2 = "MMM";
        controller.setRoverPosition(2, 8, "N", coordinate, direction, plateau);
        String expected = "2 10 N";
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveWhenEastLimitReached() {
        String input2 = "MMM";
        controller.setRoverPosition(8, 1, "E", coordinate, direction, plateau);
        String expected = "10 1 E";
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }


    @Test
    public void TestToCheckWhenObstacleEncounteredAtWest() {
        Plateau obstaclePlateau = new Plateau(10,10, obstacles);
        Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "M";
        controller.setRoverPosition(2, 8, "W", coordinate, direction, plateau);
        String expected = "2 8 W";
        String actual = controller.executeCommands(input2, rover2, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToCheckWhenObstacleEncounteredAtNorth() {
        Plateau obstaclePlateau = new Plateau(10,10, obstacles);
        Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "MM";
        controller.setRoverPosition(7, 7, "N", coordinate, direction, plateau);
        String expected = "7 8 N";
        String actual = controller.executeCommands(input2, rover2, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToCheckWhenObstacleEncounteredAtSouth() {
        Plateau obstaclePlateau = new Plateau(10,10, obstacles);
        Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "MM";
        controller.setRoverPosition(6, 9, "S", coordinate, direction, plateau);
        String expected = "6 9 S";
        String actual = controller.executeCommands(input2, rover2, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToCheckWhenObstacleEncounteredAtEast() {
        Plateau obstaclePlateau = new Plateau(10,10, obstacles);
        Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "MMM";
        controller.setRoverPosition(3, 7, "E", coordinate, direction, plateau);
        String expected = "4 7 E";
        String actual = controller.executeCommands(input2, rover2, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToCheckIfObstacleArrayisNull() {
        Plateau obstaclePlateau = new Plateau(10,10, null);
       Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "MMM";
        controller.setRoverPosition(3, 7, "E", coordinate, direction, plateau);
        String expected = "6 7 E";
        String actual = controller.executeCommands(input2, rover2, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToCheckIfObstacleArrayisEmpty() {
        ArrayList<String> emptyArray = new ArrayList<>();
        Plateau obstaclePlateau = new Plateau(10,10, emptyArray);
        Vehicle rover2 = new MarsRover(direction, coordinate, obstaclePlateau);
        String input2 = "MMM";
        controller.setRoverPosition(0, 7, "E", coordinate, direction, plateau);
        String expected = "3 7 E";
        String actual = controller.executeCommands(input2, rover, coordinate, direction);
        assertEquals(actual, expected);
    }

    @Test
    public void TestToMoveMultipleRoversInSequence() {
        Vehicle roverOne = new MarsRover(direction, coordinate, plateau);
        Vehicle roverTwo = new MarsRover(direction, coordinate, plateau);
        String input1 = "ML";
        String input2 = "MMR";
        String expected1 = "3 5 E";
        String expected2 = "2 6 E";
        controller.setRoverPosition(3, 6, "S", coordinate, direction, plateau);
        String actual1 = controller.executeCommands(input1, roverOne, coordinate, direction);
        controller.setRoverPosition(2, 4, "N", coordinate, direction, plateau);
        String actual2 = controller.executeCommands(input2, roverTwo, coordinate, direction);
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }
}

