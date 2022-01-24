package com.huma.rover;

import org.junit.Test;

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
}
