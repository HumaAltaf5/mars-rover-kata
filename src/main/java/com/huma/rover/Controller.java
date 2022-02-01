package com.huma.rover;


import static com.huma.rover.Direction.North;

public class Controller {
    Direction direction = North;
    Coordinate coordinate = new Coordinate();
    Plateau plateau  = new Plateau();
    MarsRover rover = new MarsRover(direction, coordinate, plateau);


    public void setPlateauSize(int x, int y) {
        plateau.setPlateauSize(x, y );
    }

    public void setObstacle(int x, int y, String cardinalVal) {
        plateau.setObstacle(x, y, cardinalVal);
    }

    public void getPosition(int x, int y, String cardinal) {
        coordinate.setX(x);
        coordinate.setY(y);
        direction.setDirection(cardinal);
    }

    public String executeCommands(String command) {
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
