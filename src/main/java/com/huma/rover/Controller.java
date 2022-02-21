package com.huma.rover;

public class Controller {


    public void setRoverPosition(int x, int y, String cardinal,Coordinate coordinate, Direction direction, Plateau plateau) {
        try {
            if (x > plateau.getMaxY() || y > plateau.getMaxY() || x < 0 || y < 0) {
                throw new Exception("Invalid  x and y coordinates for Rover position.");
            } else {
                coordinate.setX(x);
                coordinate.setY(y);
                direction.setDirection(cardinal);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String executeCommands(String command, Vehicle rover,Coordinate coordinate, Direction direction ) {
        for (char c : command.toCharArray()) {
            if (c == 'L') {
                rover.rotateLeft();
            } else if (c == 'R') {
                  rover.rotateRight();
            } else if (c == 'M') {
                rover.move();
            }
        }
        return coordinate.getX() + " " + coordinate.getY() + " " + direction.getDirection();
    }
}
