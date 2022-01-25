package com.huma.rover;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}
