package com.huma.rover;

public class Controller {


    public void setRoverPosition(int x, int y, String cardinal,Coordinate coordinate, Direction direction) {
        coordinate.setX(x);
        coordinate.setY(y);
        direction.setDirection(cardinal);
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
