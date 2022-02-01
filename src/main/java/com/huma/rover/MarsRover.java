package com.huma.rover;

public class MarsRover implements Rover {
    private Direction direction;
    private Coordinate coordinate;
    private Plateau plateau;

    public MarsRover(Direction direction, Coordinate coordinate, Plateau plateau) {
        this.direction = direction;
        this.coordinate = coordinate;
        this.plateau = plateau;
    }


    public void rotateLeft() {
        if(direction.getDirection().equals("N")) {
            direction.setDirection("W");
        } else if (direction.getDirection().equals("S")) {
            direction.setDirection("E");
        } else if (direction.getDirection().equals("E")) {
            direction.setDirection("N");
        } else if (direction.getDirection().equals("W")) {
            direction.setDirection("S");
        }
    }

    public void rotateRight() {
        if(direction.getDirection().equals("N")) {
            direction.setDirection("E");
        } else if (direction.getDirection().equals("S")) {
            direction.setDirection("W");
        } else if (direction.getDirection().equals("E")) {
            direction.setDirection("S");
        } else if (direction.getDirection().equals("W")) {
            direction.setDirection("N");
        }
    }

    public void move() {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (direction.getDirection().equals("N")) {
            y = (y < plateau.getMaxY() ) ? y + 1 : y;
            if (plateau.getObstacleX() == x && plateau.getObstacleY() == y) {
                y = y - 1;
            }
        } else if (direction.getDirection().equals("S")) {
            y = (y > 0) ? y - 1 : y;
        } else if (direction.getDirection().equals("E")) {
            x = (x < plateau.getMaxX()) ? x + 1 : x;
        } else if (direction.getDirection().equals("W")) {
            x = (x > 0) ? x - 1 : x;
        }
        coordinate.setX(x);
        coordinate.setY(y);
    }
}
