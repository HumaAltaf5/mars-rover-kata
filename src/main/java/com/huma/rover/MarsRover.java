package com.huma.rover;

public class MarsRover implements Vehicle {
    private Direction direction;
    private Coordinate coordinate;
    private Plateau plateau;

    public MarsRover(Direction direction, Coordinate coordinate, Plateau plateau) {
        this.direction = direction;
        this.coordinate = coordinate;
        this.plateau = plateau;
    }

    public void rotateLeft() {
        if(direction.getDirection().equals(Direction.N.toString())) {
            direction.setDirection(Direction.W.toString());
        } else if (direction.getDirection().equals(Direction.S.toString())) {
            direction.setDirection(Direction.E.toString());
        } else if (direction.getDirection().equals(Direction.E.toString())) {
            direction.setDirection(Direction.N.toString());
        } else if (direction.getDirection().equals(Direction.W.toString())) {
            direction.setDirection(Direction.S.toString());
        }
    }

    public void rotateRight() {
        if(direction.getDirection().equals(Direction.N.toString())) {
            direction.setDirection(Direction.E.toString());
        } else if (direction.getDirection().equals(Direction.S.toString())) {
            direction.setDirection(Direction.W.toString());
        } else if (direction.getDirection().equals(Direction.E.toString())) {
            direction.setDirection(Direction.S.toString());
        } else if (direction.getDirection().equals(Direction.W.toString())) {
            direction.setDirection(Direction.N.toString());
        }
    }

    public void move() {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (direction.getDirection().equals(Direction.N.toString())) {
            if(plateau.getObstacles() != null) {
                y = (y < plateau.getMaxY() && (!plateau.getObstacles().contains(x + " " + (y + 1)))) ? y + 1 : y;
            } else {
                y = (y < plateau.getMaxY()) ? y + 1 : y;
            }
        } else if (direction.getDirection().equals(Direction.S.toString())) {
            if(plateau.getObstacles() != null) {
                y = (y > 0 && (!plateau.getObstacles().contains(x + " " + (y - 1)))) ? y - 1 : y;
            } else {
                y = (y > 0) ? y - 1 : y;
            }
        } else if (direction.getDirection().equals(Direction.E.toString())){
            if(plateau.getObstacles() != null) {
                x = (x < plateau.getMaxX() && (!plateau.getObstacles().contains((x + 1) + " " + y))) ? x + 1 : x;
            } else {
                x = (x < plateau.getMaxX()) ? x + 1 : x;
            }

        } else if (direction.getDirection().equals(Direction.W.toString())) {
            if(plateau.getObstacles() != null) {
                x = (x > 0 && (!plateau.getObstacles().contains((x - 1) + " " + y))) ? x - 1 : x;
            } else {
                x = (x > 0) ? x - 1 : x;
            }
        }
        coordinate.setX(x);
        coordinate.setY(y);
    }
}
